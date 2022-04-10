#Define base docker image

FROM openjdk:17-alpine
LABEL maintainer="mosi"

ARG JAR_FILE=target/shopping-cart-app-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} shopping-cart-app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/shopping-cart-app.jar"]
