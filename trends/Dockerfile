FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/trends-1.0-SNAPSHOT.jar trends-service.jar

EXPOSE 8084
ENTRYPOINT ["java", "-jar", "trends-service.jar"]
