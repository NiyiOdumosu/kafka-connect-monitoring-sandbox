#Kafka Streams XML to JSON converter

##Building

    mvn package -DskipTests
  
## Running

    java -Dlog4j.level=INFO -javaagent:/Users/kiril/Downloads/jolokia-1.6.2/agents/jolokia-jvm.jar=port=7777,host=localhost  -jar target/shipment-transformation-xml-1.0-SNAPSHOT.jar