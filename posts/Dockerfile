
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/posts-1.0-SNAPSHOT.jar posts-service.jar

ENTRYPOINT ["java", "-jar", "posts-service.jar"]
