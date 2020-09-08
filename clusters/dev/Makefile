ENVIRONMENT_NAME := jeqo-aramex
ENVIRONMENT_ID := t37130

get_environment:
	ccloud environment list -o json | jq -r '.[] | select(.name=="${ENVIRONMENT_NAME}") | .id'

use_environment:
	ccloud environment use ${ENVIRONMENT_ID}

CLUSTER_NAME := amx-kafka-dev
CLOUD_PROVIDER := aws
CLOUD_REGION := eu-west-1
CLUSTER_AVAILABILITY := single-zone
CLUSTER_TYPE := basic

cluster: use_environment
	ccloud kafka cluster create ${CLUSTER_NAME} \
		--cloud ${CLOUD_PROVIDER} \
		--region ${CLOUD_REGION} \
		--availability ${CLUSTER_AVAILABILITY} \
		--type ${CLUSTER_TYPE}

schema-registry:
	ccloud schema-registry cluster enable --cloud aws --geo eu