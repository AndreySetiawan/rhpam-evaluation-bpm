#FROM java:8
FROM openjdk:8-jdk-alpine

WORKDIR /opt
# This copies to local fat jar inside the image

ADD /bpm-evaluation-service-0.1.0.jar /app/appname.jar

# What to run when the container starts
ENTRYPOINT [ "java", "-jar", "/app/appname.jar" ]

# Ports used by the app
EXPOSE 8078