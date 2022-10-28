FROM openjdk:17
WORKDIR /app
ADD target/rest-api.jar .
EXPOSE 8083
ENTRYPOINT ["java","-jar","rest-api.jar"]

