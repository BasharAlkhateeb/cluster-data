FROM maven:3.5-jdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package -DskipTests


FROM openjdk:11
WORKDIR /app
COPY --from=build /usr/src/app/target/clustered-data-0.0.1-SNAPSHOT.jar  /app/app.jar
#EXPOSE 8080
#EXPOSE 3306
CMD ["java", "-jar", "/app/app.jar"]

