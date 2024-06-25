FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/courses-1.0-SNAPSHOT.jar courses-service.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "courses-service.jar"]
