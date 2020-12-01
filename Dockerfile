FROM openjdk:8-jre-alpine
ADD target/springboot.configmap-1.0.0.jar app.jar
CMD chmod +777 app.jar
CMD java -jar app.jar