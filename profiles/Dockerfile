FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY target/profiles-1.0-SNAPSHOT.jar profiles-service.jar

ENTRYPOINT ["java", "-jar", "profiles-service.jar"]
