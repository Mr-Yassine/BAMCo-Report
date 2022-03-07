FROM openjdk:11
EXPOSE 8080
ADD target/bamco-image.jar bamco-image.jar
ENTRYPOINT ["java", "-jar", "/bamco-image.jar"]
