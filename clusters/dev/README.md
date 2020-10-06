# Topic creation script

create_topics.sh is intended to be run as part of a CI job to create required topics in a Confluent Cloud cluster

In order for script to work the following environment variables must be defined:

```bash
export CCLOUD_BOOTSTRAP_SERVERS=hostname:port
export CCLOUD_SASL_JAAS_CONFIG='org.apache.kafka.common.security.plain.PlainLoginModule   required username="username"   password="password"    ;'
export TOPOLOGY_DEFINITION_YAML=/tmp/toplogy.yaml
```

This script also expects to find a [kafka-topology-builder](https://github.com/purbon/kafka-topology-builder) jar named `kafka-topology-builder.jar` in the same directory.

You can download the snapshot build of the kafka-topilogy-builder [here](http://ln.kiril.org/Q2IMJl+) or checkout the repo and build the latest jar using `mvn pacage -DskipTests` command.

# Running the script

./create_topics.sh
