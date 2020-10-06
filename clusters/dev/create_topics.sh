#!/usr/bin/env bash

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

if [[ ! -f kafka-topology-builder-jar-with-dependencies.jar ]]; then
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

java -jar kafka-topology-builder-jar-with-dependencies.jar \
                --brokers ${CCLOUD_BOOTSTRAP_SERVERS} \
                --clientConfig ${RAND_ID}.ccloud.properties \
                --topology ./topologies/aramex.yml



