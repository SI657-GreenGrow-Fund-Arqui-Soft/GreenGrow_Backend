FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/api-gateway-eureka-1.0-SNAPSHOT.jar api-gateway.jar

EXPOSE 8000
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]