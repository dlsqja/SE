FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 443
ENTRYPOINT ["java","-jar","/app.jar"]