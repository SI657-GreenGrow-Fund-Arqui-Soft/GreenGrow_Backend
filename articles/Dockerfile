FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/articles-1.0-SNAPSHOT.jar articles-service.jar

ENTRYPOINT ["java", "-jar", "articles-service.jar"]
