FROM openjdk:8

WORKDIR ./spring-server

ADD ./spring-server/src ./spring-server/src
COPY ./docker/openjdk/application.properties ./src/main/resources/application.properties

RUN bash -c 'mvn compile spring-boot:run spring-server/src/main/java/ch/heigvd/quaris/Swagger2SpringBoot.java'
