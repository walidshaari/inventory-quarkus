FROM registry.access.redhat.com/ubi8/openjdk-17:1.14
ENV PROFILE=prod
ADD target/*.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
