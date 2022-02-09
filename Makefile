all: build

# These commands download connectors
connector-download:
	mkdir -p connector-plugins
	wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-jdbc/versions/10.2.0/confluentinc-kafka-connect-jdbc-10.3.2.zip
	unzip confluentinc-kafka-connect-jdbc-10.3.2.zip -d connector-plugins
	rm confluentinc-kafka-connect-jdbc-10.3.2.zip
	wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-datagen/versions/0.5.0/confluentinc-kafka-connect-datagen-0.5.3.zip
	unzip confluentinc-kafka-connect-datagen-0.5.3.zip -d connector-plugins
	rm confluentinc-kafka-connect-datagen-0.5.3.zip

# These commands get set up your local CP cluster

up:
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

down:
	docker-compose down --remove-orphans

local-topology:
	docker-compose exec topology-builder kafka-topology-builder.sh --brokers kafka1:19092 --clientConfig /topologies/local.properties --topology /topologies/local.yml

make local-topic:
	kafka-topics --create --topic test1 --bootstrap-server kafka1:19092

# The following commands are for connectors that are RW to the local CP cluster

local-datagen-commercials:
	curl -X PUT --data @connectors/local/datagen-commercials.json -H "Content-type: application/json" http://localhost:8084/connectors/datagen-commercials/config | jq

local-datagen-inventory:
	curl -X PUT --data @connectors/local/datagen.json -H "Content-type: application/json" http://localhost:8084/connectors/datagen-inventory/config | jq

local-jdbc-mysql:
	curl -X PUT --data @connectors/local/jdbc-mysql.json -H "Content-type: application/json" http://localhost:8084/connectors/jdbc-mysql/config | jq

local-jdbc-mysql-custom-query:
	curl -X PUT --data @connectors/local/oracle-sink.json -H "Content-type: application/json" http://localhost:8084/connectors/jdbc-mysql-custom-query/config | jq

local-jdbc-sink:
	curl -X PUT --data @connectors/ccloud/jdbc-sink-schema.json -H "Content-type: application/json" http://localhost:8084/connectors/jdbc-sink-schema/config | jq

local-get-connectors:
	curl http://localhost:8084/connectors/ | jq

local-remove-connector:
	curl -X DELETE http://localhost:8084/connectors/| jq

logs-connect:
	docker logs -f connect1



# Run these commands to set up your connect cluster and authentication credentials for Confluent Cloud
include env

ccloud-exporter-api-key: ccloud-pre
	ccloud api-key create --resource cloud

ccloud-topology:
	docker-compose exec topology-builder kafka-topology-builder.sh \
		--brokers ${CCLOUD_BOOTSTRAP_SERVERS} \
		--clientConfig /topologies/ccloud.properties \
		--topology /topologies/ccloud.yml

ccloud-pre:
	confluent environment use ${CCLOUD_ENV}
	confluent kafka cluster use ${CCLOUD_CLUSTER}

ccloud-connect-api-key: ccloud-pre
	confluent api-key create --resource ${CCLOUD_CLUSTER} --description "Cloud API-Key for Connect Monitoring Demo"
	confluent api-key create --resource ${CCLOUD_SR} --description "Cloud API-Key for Connect Monitoring Demo"

ccloud-topologybuilder-api-key: ccloud-pre
	confluent api-key create --resource ${CCLOUD_CLUSTER} --description "Connect Monitoring PoC Topology Builder"

ccloud-app-service-account: ccloud-pre
	confluent service-account create connect-sandbox --description "Connect Monitoring PoC Topology Builder"

ccloud-app-acl: ccloud-pre
	confluent kafka acl create --allow --service-account ${CCLOUD_SERVICE_ACCOUNT} \
		--operation DESCRIBE --operation CREATE --operation READ --operation WRITE \
		--topic  demo-test-topic --prefix
	confluent kafka acl create --allow --service-account ${CCLOUD_SERVICE_ACCOUNT} \
		--operation DESCRIBE --operation READ \
		--consumer-group  demo-test-topic --prefix

ccloud-app-api-key: ccloud-pre
	confluent api-key create --service-account ${CCLOUD_SERVICE_ACCOUNT} --resource ${CCLOUD_CLUSTER} --description "Confluent Cloud Connect Monitoring Service Account"
	confluent api-key create --service-account ${CCLOUD_SERVICE_ACCOUNT} --resource ${CCLOUD_SR} --description "Confluent Cloud Connect Monitoring Service Accoun - SR"


# These commands deploy connectors that RW to your Confluent Cloud cluster

ccloud-topic: ccloud-pre
	confluent kafka topic create test-topic

ccloud-datagen-users:
	curl -X PUT --data @connectors/ccloud/datagen-users.json -H "Content-type: application/json" http://localhost:8083/connectors/datagen-users/config | jq

ccloud-datagen-users-schema:
	curl -X PUT --data @connectors/ccloud/datagen-users-schema.json -H "Content-type: application/json" http://localhost:8083/connectors/datagen-users-schema/config | jq

ccloud-jdbc-bulk-mode-source:
	curl -X PUT --data @connectors/ccloud/jdbc-bulk-mode-source.json -H "Content-type: application/json" http://localhost:8083/connectors/jdbc-bulk-mode-source/config | jq

ccloud-jdbc-incremental-mode-source:
	curl -X PUT --data @connectors/ccloud/jdbc-incremental-mode-source.json -H "Content-type: application/json" http://localhost:8083/connectors/jdbc-incremental-mode-source/config | jq

ccloud-jdbc-timestamp-mode-source:
	curl -X PUT --data @connectors/ccloud/jdbc-timestamp-mode-source.json -H "Content-type: application/json" http://localhost:8083/connectors/jdbc-timestamp-mode-source/config | jq

ccloud-jdbc-incremental-timestamp-source:
	curl -X PUT --data @connectors/ccloud/jdbc-incremental-timestamp-source.json -H "Content-type: application/json" http://localhost:8083/connectors/jdbc-incremental-timestamp-source/config | jq

ccloud-jdbc-sink:
	curl -X PUT --data @connectors/ccloud/jdbc-sink.json -H "Content-type: application/json" http://localhost:8083/connectors/jdbc-sink/config | jq

ccloud-get-connectors:
	curl http://localhost:8083/connectors/ | jq

ccloud-remove-connector:
	curl -X DELETE http://localhost:8083/connectors/| jq


ccloud-perf: ccloud-pre
	confluent kafka topic create demo-test-topic

# Below are perf test commands. If you want to send some data to the CC cluster for monitoring without deploying a connector, use this

perf-producer:
	kafka-producer-perf-test \
		--producer-props bootstrap.servers=${CCLOUD_BOOTSTRAP_SERVERS} \
		--topic demo-test-topic \
		--num-records 1000000 --record-size 1000 --throughput 500 \
		--producer.config perf/ccloud.properties

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
