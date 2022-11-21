FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} marca-entrada-salida-service.jar
ENTRYPOINT ["java","-jar","/marca-entrada-salida-service.jar"]