FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/trends-1.0-SNAPSHOT.jar trends-service.jar

ENTRYPOINT ["java", "-jar", "trends-service.jar"]
