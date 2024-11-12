# Etapa de Execução
FROM openjdk:17-jdk

WORKDIR /app

COPY ./target/ecommerce-project-springboot-0.0.1-SNAPSHOT.jar /app/test-store.jar


CMD ["java", "-jar", "/app/test-store.jar"]

EXPOSE 8080

LABEL authors="Tatiane Mendonça"