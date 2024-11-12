# Build com Maven
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk

COPY --from=build /app/target/ecommerce-project-springboot-0.0.1-SNAPSHOT.jar /app/test-store.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/test-store.jar"]

LABEL authors="Tatiane Mendonça"

