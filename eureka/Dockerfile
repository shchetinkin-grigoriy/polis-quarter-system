FROM openjdk:8-jdk-alpine
MAINTAINER Grigoriy Shchetinkin
RUN apk --no-cache add curl
WORKDIR /
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
HEALTHCHECK --interval=20s --timeout=60s CMD curl -f http://localhost:9091/actuator/health || exit 1
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 9091