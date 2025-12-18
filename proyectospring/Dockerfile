FROM eclipse-temurin:21-jdk

WORKDIR /app

ARG JAR_FILE=target/proyectospring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_spring.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app_spring.jar"]
