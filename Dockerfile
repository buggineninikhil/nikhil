FROM java:8
EXPOSE 8080
ADD articlemicroservice.jar articlemicroservice.jar
ENTRYPOINT ["java", "-jar", "articlemicroservice.jar"]