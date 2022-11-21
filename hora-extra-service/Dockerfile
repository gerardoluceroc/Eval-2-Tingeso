FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hora-extra-service.jar
ENTRYPOINT ["java","-jar","/hora-extra-service.jar"]