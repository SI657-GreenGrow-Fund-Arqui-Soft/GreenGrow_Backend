
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/discovery-server-1.0-SNAPSHOT.jar discovery-server.jar

EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]
