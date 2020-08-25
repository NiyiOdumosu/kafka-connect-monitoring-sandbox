all: build

build:
	./mvnw clean compile

connector-download:
	mkdir -p connector-plugins
	wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-aws-lambda/versions/1.0.3/confluentinc-kafka-connect-aws-lambda-1.0.3.zip
	unzip confluentinc-kafka-connect-aws-lambda-1.0.3.zip -d connector-plugins
	rm confluentinc-kafka-connect-aws-lambda-1.0.3.zip
	wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-rabbitmq-sink/versions/1.3.0-preview/confluentinc-kafka-connect-rabbitmq-sink-1.3.0-preview.zip
	unzip confluentinc-kafka-connect-rabbitmq-sink-1.3.0-preview.zip -d connector-plugins
	rm confluentinc-kafka-connect-rabbitmq-sink-1.3.0-preview.zip

rabbitmq:
	docker exec poc-aramex_rabbitmq1_1 rabbitmqadmin declare exchange name=kafka type=fanout
	docker exec poc-aramex_rabbitmq1_1 rabbitmqadmin declare queue name=test durable=true
	docker exec poc-aramex_rabbitmq1_1 rabbitmqadmin declare binding source=kafka destination_type=queue destination=test routing_key=5

local-connector-rabbitmq:
	curl -X POST --data @connectors/local/rabbitmq-connector.json -H "Content-type: application/json" http://localhost:8083/connectors

local-connector-awslambda:
	curl -X POST --data @connectors/local/awslambda-connector-avro.json -H "Content-type: application/json" http://localhost:8083/connectors
	curl -X POST --data @connectors/local/awslambda-connector-json.json -H "Content-type: application/json" http://localhost:8083/connectors
	curl -X POST --data @connectors/local/awslambda-connector-jsonschema.json -H "Content-type: application/json" http://localhost:8083/connectors

local-up:
	docker-compose -f local.yml up -d

local-down:
	docker-compose -f local.yml down --remove-orphans

local-topology:
	docker-compose exec topology-builder kafka-topology-builder.sh --brokers kafka1:19092 --clientConfig /topologies/local.properties --topology /topologies/local.yml

local-producer: build
	./mvnw exec:java -Dexec.mainClass="poc.producer.Main"

local-streams: build
	./mvnw exec:java -Dexec.mainClass="poc.adapter.Main"

include env

ccloud-exporter-api-key: ccloud-pre
	ccloud api-key create --resource cloud

ccloud-up:
	CCLOUD_CLUSTER=${CCLOUD_CLUSTER} \
	CCLOUD_BOOTSTRAP_SERVERS=${CCLOUD_BOOTSTRAP_SERVERS} \
	CCLOUD_EXPORTER_API_KEY=${CCLOUD_EXPORTER_API_KEY} \
	CCLOUD_EXPORTER_API_SECRET=${CCLOUD_EXPORTER_API_SECRET} \
	CCLOUD_API_KEY=${CCLOUD_CONNECT_API_KEY} \
	CCLOUD_API_SECRET=${CCLOUD_CONNECT_API_SECRET} \
	CCLOUD_SR_URL=${CCLOUD_SR_URL} \
	CCLOUD_SR_API_KEY=${CCLOUD_CONNECT_SR_API_KEY} \
	CCLOUD_SR_API_SECRET=${CCLOUD_CONNECT_SR_API_SECRET} \
	docker-compose -f ccloud.yml up -d

ccloud-down:
	docker-compose -f ccloud.yml down --remove-orphans

ccloud-topology:
	docker-compose -f ccloud.yml exec topology-builder kafka-topology-builder.sh --brokers ${CCLOUD_BOOTSTRAP_SERVERS} --clientConfig /topologies/ccloud.properties --topology /topologies/ccloud.yml

ccloud-connector-rabbitmq:
	curl -X POST --data @connectors/ccloud/rabbitmq-connector.json -H "Content-type: application/json" http://localhost:8083/connectors

ccloud-connector-awslambda:
	curl -X POST --data @connectors/ccloud/awslambda-connector-avro.json -H "Content-type: application/json" http://localhost:8083/connectors
	curl -X POST --data @connectors/ccloud/awslambda-connector-json.json -H "Content-type: application/json" http://localhost:8083/connectors
	curl -X POST --data @connectors/ccloud/awslambda-connector-jsonschema.json -H "Content-type: application/json" http://localhost:8083/connectors

ccloud-pre:
	ccloud environment use ${CCLOUD_ENV}
	ccloud kafka cluster use ${CCLOUD_CLUSTER}

ccloud-connect-api-key: ccloud-pre
	ccloud api-key create --resource ${CCLOUD_CLUSTER} --description "Aramex PoC Kafka Connect"
	ccloud api-key create --resource ${CCLOUD_SR} --description "Aramex PoC Kafka Connect - SR"

ccloud-topologybuilder-api-key: ccloud-pre
	ccloud api-key create --resource ${CCLOUD_CLUSTER} --description "Aramex PoC Topology Builder"

ccloud-app-service-account: ccloud-pre
	ccloud service-account create aramex-poc --description "Confluent PoC for Aramex"

ccloud-app-acl: ccloud-pre
	ccloud kafka acl create --allow --service-account ${CCLOUD_SERVICE_ACCOUNT} --operation DESCRIBE --operation CREATE --operation READ --operation WRITE --topic  aramex.poc --prefix
	ccloud kafka acl create --allow --service-account ${CCLOUD_SERVICE_ACCOUNT} --operation DESCRIBE --operation READ --consumer-group  aramex-poc --prefix

ccloud-app-api-key: ccloud-pre
	ccloud api-key create --service-account ${CCLOUD_SERVICE_ACCOUNT} --resource ${CCLOUD_CLUSTER} --description "Confluent PoC for Aramex"
	ccloud api-key create --service-account ${CCLOUD_SERVICE_ACCOUNT} --resource ${CCLOUD_SR} --description "Confluent PoC for Aramex - SR"

ccloud-producer:
	CCLOUD_BOOTSTRAP_SERVERS=${CCLOUD_BOOTSTRAP_SERVERS} \
	CCLOUD_API_KEY=${CCLOUD_API_KEY} \
	CCLOUD_API_SECRET=${CCLOUD_API_SECRET} \
	./mvnw exec:java -Dexec.mainClass="poc.producer.Main" -Dconfig.file=src/main/resources/ccloud.conf

ccloud-streams:
	CCLOUD_BOOTSTRAP_SERVERS=${CCLOUD_BOOTSTRAP_SERVERS} \
	CCLOUD_API_KEY=${CCLOUD_API_KEY} \
	CCLOUD_API_SECRET=${CCLOUD_API_SECRET} \
	CCLOUD_SR_URL=${CCLOUD_SR_URL} \
	CCLOUD_SR_API_KEY=${CCLOUD_SR_API_KEY} \
	CCLOUD_SR_API_SECRET=${CCLOUD_SR_API_SECRET} \
	./mvnw exec:java -Dexec.mainClass="poc.adapter.Main" -Dconfig.file=src/main/resources/ccloud.conf