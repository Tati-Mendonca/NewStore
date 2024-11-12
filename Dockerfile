# Build com Maven
FROM openjdk:17-slim as builder

RUN apt-get clean && apt-get update && apt-get install -y maven

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=builder /app/target/ecommerce-project-springboot-0.0.1-SNAPSHOT.jar /app/test-store.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/test-store.jar"]

LABEL authors="Tatiane Mendonça"

