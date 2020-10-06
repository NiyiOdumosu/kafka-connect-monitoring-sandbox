#!/usr/bin/env bash

# This scripts creates topics based on a provided topology defintion file
#
# This scripts exepects to find kafka-topology-builder.jar file in the
# same directory where it is running from.
#
# Required environment variables:
# CCLOUD_BOOTSTRAP_SERVERS=hostname:port
# CCLOUD_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule   required username="username"   password="password";
# TOPOLOGY_DEFINITION_YAML=/tmp/toplogy.yaml



function finish {
  rm -rf ${RAND_ID}.ccloud.properties
}
trap finish EXIT

RAND_ID=${BASHPID}

if [[ -z "${CCLOUD_BOOTSTRAP_SERVERS}" ]]; then
  echo "CCLOUD_BOOTSTRAP_SERVERS env varaiable is undefined. Exiting"
	exit 1
fi

if [[ -z "${CCLOUD_SASL_JAAS_CONFIG}" ]]; then
  echo "CCLOUD_SASL_JAAS_CONFIG env varaiable is undefined. Exiting"
	exit 1
fi

if [[ -z "${TOPOLOGY_DEFINITION_YAML}" || ! -f "${TOPOLOGY_DEFINITION_YAML}" ]]; then
  echo "TOPOLOGY_DEFINITION_YAML env varaiable is undefined or YAML file does not exist. Exiting"
  exit 1
fi

if [[ ! -f kafka-topology-builder.jar ]]; then
  echo "Can't find kafka-topology-builder jar. Exiting"
  exit 1
fi


cat << EOF > ./$RAND_ID.ccloud.properties
security.protocol=SASL_SSL
sasl.jaas.config=${CCLOUD_SASL_JAAS_CONFIG}
ssl.endpoint.identification.algorithm=https
sasl.mechanism=PLAIN
request.timeout.ms=3000
EOF

java -jar kafka-topology-builder.jar \
                --brokers ${CCLOUD_BOOTSTRAP_SERVERS} \
                --clientConfig ${RAND_ID}.ccloud.properties \
                --topology ${TOPOLOGY_DEFINITION_YAML}



