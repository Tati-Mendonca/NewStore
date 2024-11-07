FROM openjdk:17-jdk

COPY target/ecommerce-project-springboot-0.0.1-SNAPSHOT.jar /app/store.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/jobis.jar"]

LABEL authors="Tatiane Mendonça"