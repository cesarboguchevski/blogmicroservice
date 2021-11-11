FROM adoptopenjdk:11-jre-hotspot as builder
MAINTAINER my_project.com
COPY build/libs/blogMicroservice-1.0.0.jar blogMicroservice-1.0.0.jar
ENTRYPOINT ["java","-jar","/blogMicroservice-1.0.0.jar"]