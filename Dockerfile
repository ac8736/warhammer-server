FROM eclipse-temurin:17-jdk-alpine
ENV SERVER_PORT=8080
ENV SERVER_ADDRESS=0.0.0.0
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]