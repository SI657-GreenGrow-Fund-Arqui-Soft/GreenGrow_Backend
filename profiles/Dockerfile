FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY target/profiles-1.0-SNAPSHOT.jar profiles-service.jar

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "profiles-service.jar"]
