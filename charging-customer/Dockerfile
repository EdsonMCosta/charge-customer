FROM openjdk:11-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/charging-customer-0.0.1.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]