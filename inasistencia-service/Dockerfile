FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} inasistencia-service.jar
ENTRYPOINT ["java","-jar","/inasistencia-service.jar"]