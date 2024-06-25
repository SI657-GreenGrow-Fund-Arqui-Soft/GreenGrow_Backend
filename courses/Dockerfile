FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/courses-1.0-SNAPSHOT.jar courses-service.jar

ENTRYPOINT ["java", "-jar", "courses-service.jar"]
