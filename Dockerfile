FROM maven:3.9.7-eclipse-temurin-21-alpine  AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app

RUN mvn clean package -DskipTests

FROM openjdk:21 AS app
WORKDIR /app
COPY --from=build app/target/food-service-manager.jar /app/food-service-manager.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/food-service-manager.jar"]