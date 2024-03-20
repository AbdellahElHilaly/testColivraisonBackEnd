FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/CoLivraison-0.0.1-SNAPSHOT.jar .

COPY src/main/resources/application.yml .

EXPOSE 8080

CMD ["java", "-jar", "CoLivraison-0.0.1-SNAPSHOT.jar"]