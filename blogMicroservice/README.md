## *Instructions for microservice build and deploy*


This project is a springboot designed to run a microservice on Google's Cloud Run.
To run it is necessary to mount an image of the container, include it in the Container Registry and configure
on a microservice in Cloud Run.    

## Pre-conditions

1. Have an account on Google Cloud platform and Cloud Run;
2. Have an enviroment setup with  Docker, Gradle and JDK 11;
3. Have access to gcloud SDK to use shell commands.

## Walkthrough: build docker image

After downloading the project, it is necessary to apply the following steps:

1. Generate gradlew package for docker:  ./gradlew -Dorg.gradle.java.home=/usr/lib/jvm/java-1.14.0-openjdk-amd64/  build

2. Test the generated package: java -jar build/libs/blogMicroservice-1.0.0.jar

3. Apply build and tag to container image: sudo docker build --tag=blogMicroservice:latest .

4. Docker run test: sudo docker run -p 8090:8090 blogMicroservice:latest . 

5. Upload docker image to google container registry:
   sudo docker tag blogMicroservice gcr.io/my_project/blogMicroservice:latest
   gcloud docker --verbosity=error -- push gcr.io/my_project/blogMicroservice


## Configure on GKE
## ref: https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app

1. kubectl create deployment blogMicroservice --image=gcr.io/my_project/blogMicroservice
2. kubectl scale deployment blogMicroservice --replicas=3
3. kubectl autoscale deployment blogMicroservice --cpu-percent=80 --min=1 --max=5
4. kubectl expose deployment blogMicroservice --name=blogMicroservice --type=LoadBalancer --port 8090 --target-port 8090


## Configure in Cloud Run

It is now possible to configure using the Cloud Run console:

1. Access your cloud run account and create a new service or edit an existing one;
2. Point to the image that should be automatically recognized from the container registry;
3. Configure the ports and forms of traffic. Pay attention to ports that need to comply with health check.
4. Finalize configurations with deploy.
---
