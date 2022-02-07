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
	wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-jdbc/versions/10.2.0/confluentinc-kafka-connect-jdbc-10.2.0.zip
	unzip confluentinc-kafka-connect-jdbc-10.2.0.zip -d connector-plugins
	rm confluentinc-kafka-connect-jdbc-10.2.0.zip

datagen-download:
	wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-datagen/versions/0.5.0/confluentinc-kafka-connect-datagen-0.5.0.zip

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

local-connector-jdbc:
	docker exec poc-aramex_connect1_1 curl -X POST --data @connectors/local/mysql.json -H "Content-type: application/json" http://localhost:8083/connectors | jq

local-connector-datagen-users:
	curl -X PUT --data @connectors/local/datagen.json -H "Content-type: application/json" http://localhost:8084/connectors/datagen-users/config | jq

local-connector-datagen-inventory:
	curl -X PUT --data @connectors/local/datagen-inventory.json -H "Content-type: application/json" http://localhost:8083/connectors/datagen-inventory/config | jq

local-connector-oracle:
	curl -X PUT --data @connectors/local/oracle-sink.json -H "Content-type: application/json" http://localhost:8083/connectors/niyi-oracle-sink/config | jq

geico-timestamp-view-source-connector:
	curl -X PUT --data @connectors/ccloud/geico-timestamp-view-source.json -H "Content-type: application/json" http://localhost:8083/connectors/geico-timestamp-view-source/config | jq

geico-incremental-timestamp-view-source-connector:
	curl -X PUT --data @connectors/ccloud/geico-incremental-timestamp-source.json -H "Content-type: application/json" http://localhost:8083/connectors/geico-incremental-timestamp-view-source/config | jq

geico-bulk-view-source-connector:
	curl -X PUT --data @connectors/ccloud/geico-bulk-view-source.json -H "Content-type: application/json" http://localhost:8083/connectors/geico-bulk-view-source/config | jq

oracle-demo-warehouse:
 	curl -X PUT --data '{"connector.class":"io.confluent.connect.oracle.cdc.OracleCdcSourceConnector","oracle.password":"dwm_admin123","oracle.sid":"ORCL","topic.creation.default.partitions":"1","table.topic.name.template":"${databaseName}.${schemaName}.${tableName}","tasks.max":"1","topic.creation.redo.partitions":"1","topic.creation.redo.include":"oracle-redo-log-topic","topic.creation.default.replication.factor":"3","lob.topic.name.template":"${databaseName}.${schemaName}.${tableName}.${columnName}","topic.creation.redo.retention.ms":"1209600000","value.converter":"org.apache.kafka.connect.json.JsonConverter","key.converter":"org.apache.kafka.connect.storage.StringConverter","redo.log.row.fetch.size":"1","oracle.server":"dwm-demo.cjg294eidfaj.us-west-2.rds.amazonaws.com","topic.creation.redo.replication.factor":"3","topic.creation.default.cleanup.policy":"compact","oracle.port":"1521","topic.creation.redo.cleanup.policy":"delete","topic.creation.groups":"redo","oracle.username":"admin","value.converter.schema.registry.url":"http://schemaregistry.confluent.svc.cluster.local:8081","start.from":"SNAPSHOT","table.inclusion.regex":"ORCL.ADMIN.*","name":"OracleCdcSourceConnectorConnector_2","numeric.mapping":"best_fit","max.batch.size":"100", "confluent.topic.bootstrap.servers": "kafka:9071", "redo.log.consumer.bootstrap.servers": "kafka:9071" }' -H "Content-type: application/json" localhost:8083/connectors/OracleCdcSourceConnectorConnector_2/config

local-custom-query:
	curl -X POST --data @connectors/local/mysql-custom-query.json -H "Content-type: application/json" http://localhost:8083/connectors | jq

local-remove-connector:
	curl -X DELETE http://localhost:8083/connectors/| jq

get-connectors:
	curl http://localhost:8083/connectors/ | jq

logs-connect:
	docker-compose logs -f connect1

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
	docker-compose up -d

ccloud-down:
	docker-compose down --remove-orphans

ccloud-topology:
	docker-compose exec topology-builder kafka-topology-builder.sh \
		--brokers ${CCLOUD_BOOTSTRAP_SERVERS} \
		--clientConfig /topologies/ccloud.properties \
		--topology /topologies/aramex.yml

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
	ccloud kafka acl create --allow --service-account ${CCLOUD_SERVICE_ACCOUNT} \
		--operation DESCRIBE --operation CREATE --operation READ --operation WRITE \
		--topic  aramex.poc --prefix
	ccloud kafka acl create --allow --service-account ${CCLOUD_SERVICE_ACCOUNT} \
		--operation DESCRIBE --operation READ \
		--consumer-group  aramex-poc --prefix

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

perf-topic: ccloud-pre
	ccloud kafka topic create perf1

producer:
	kafka-producer-perf-test \
    		--producer-props bootstrap.servers=localhost:9092 \
    		--topic demo-test-topic \
    		--num-records 10000000 --record-size 1000 --throughput 500
#    		--producer.config perf/throughput.properties


perf-producer:
	kafka-producer-perf-test \
		--producer-props bootstrap.servers=${CCLOUD_BOOTSTRAP_SERVERS} \
		--topic demo-test-topic \
		--num-records 1000000 --record-size 1000 --throughput 500 \
		--producer.config perf/client.properties

perf-producer-throughput:
	kafka-producer-perf-test \
		--producer-props bootstrap.servers=${CCLOUD_BOOTSTRAP_SERVERS} \
		--topic demo-test-topic \
		--num-records 1000000 --record-size 1000 --throughput -1 \
		--producer.config perf/throughput.properties

perf-consumer:
	kafka-consumer-perf-test \
		--bootstrap-server ${CCLOUD_BOOTSTRAP_SERVERS} \
		--topic demo-test-topic --group g1 \
		--messages 100000 --threads 10  \
		--show-detailed-stats \
		--consumer.config perf/client.properties

ccloud-consumer:
	kafka-console-consumer \
		--bootstrap-server ${CCLOUD_BOOTSTRAP_SERVERS} \
		--topic MOCK_DATA_VIEW --group v1 \
		--consumer.config perf/throughput.properties \
		--from-beginning

local-consumer:
	kafka-console-consumer \
		--bootstrap-server http://localhost:19092 \
		--topic users-schema --group poc1 \
		--from-beginning

#  broker_list topic num_messages producer_acks message_size_bytes
perf-e2e-latency:
	kafka-run-class kafka.tools.EndToEndLatency \
		${CCLOUD_BOOTSTRAP_SERVERS} \
		perf1 \
		1000 \
		all \
		100 \
		perf/client.properties
