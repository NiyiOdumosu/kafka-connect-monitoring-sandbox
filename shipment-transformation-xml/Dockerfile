FROM maven:3.6.3-openjdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN curl https://repo1.maven.org/maven2/org/jolokia/jolokia-jvm/1.6.2/jolokia-jvm-1.6.2-agent.jar -o /jolokia-jvm-1.6.2-agent.jar
RUN mvn -f /usr/src/app/pom.xml clean test package

FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY --from=build /usr/src/app/target/shipment-transformation-xml-1.5-SNAPSHOT.jar /usr/app/shipment-transformation-xml-1.5-SNAPSHOT.jar
COPY --from=build /jolokia-jvm-1.6.2-agent.jar /usr/app/jolokia-jvm-1.6.2-agent.jar
EXPOSE 7777
ENTRYPOINT ["java", \
            "-javaagent:/usr/app/jolokia-jvm-1.6.2-agent.jar=port=7777,host=0.0.0.0", \
            "-Xms512m","-Xmx1024m", \
            "-jar","/usr/app/shipment-transformation-xml-1.5-SNAPSHOT.jar"]