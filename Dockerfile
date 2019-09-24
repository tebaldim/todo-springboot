FROM maven:3.5-jdk-8 as builder
COPY . /tmp/src
WORKDIR /tmp/src
ADD maven-settings.xml /root/.m2/settings.xml
RUN mvn -B -DskipTests clean install


FROM openjdk:8-jdk-alpine
RUN apk add --update tzdata
ENV TZ Europe/Rome
EXPOSE 8080
WORKDIR /app
COPY --from=builder /tmp/src/target/todo-springboot-0.0.1-SNAPSHOT.jar .
CMD  ["java", "-jar", "todo-springboot-0.0.1-SNAPSHOT.jar"]
