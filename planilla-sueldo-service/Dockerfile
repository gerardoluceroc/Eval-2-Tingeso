FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} planilla-sueldo-service.jar
ENTRYPOINT ["java","-jar","/planilla-sueldo-service.jar"]