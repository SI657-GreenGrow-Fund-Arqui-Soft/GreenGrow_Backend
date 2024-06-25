FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY target/articles-1.0-SNAPSHOT.jar articles-service.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "articles-service.jar"]
