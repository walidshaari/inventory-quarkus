FROM registry.access.redhat.com/ubi9/openjdk-17-runtime:1.13
ENV PROFILE=prod
ADD target/*.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
