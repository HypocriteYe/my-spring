FROM openjdk:8-jdk-slim
LABEL maintainer=huagu

COPY target/*.jar   /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]