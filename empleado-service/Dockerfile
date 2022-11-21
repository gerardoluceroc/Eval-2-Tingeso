FROM openjdk:17
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar 
#COPY --from=build target/demo-0.0.1-SNAPSHOT.jar appTingeso.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} empleado-service.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","/empleado-service.jar"]