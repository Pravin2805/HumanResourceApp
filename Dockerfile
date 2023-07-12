FROM openjdk:17-alpine
COPY SampleApp.jar SampleApp.jar
EXPOSE 9093
ENTRYPOINT ["java","-jar","/SampleApp.jar"]