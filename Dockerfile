FROM maven:3.9.6-jdk-17-slim-bullseye AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jre-focal

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]