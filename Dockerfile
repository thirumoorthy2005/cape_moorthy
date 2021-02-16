FROM openjdk:8
FROM maven:alpine

# image layer
WORKDIR /capeelectric
ADD pom.xml /capeelectric
RUN mvn verify clean --fail-never

COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8086
VOLUME /tmp
ADD target/LV-Safety-Verification-0.0.1-SNAPSHOT.jar LV-Safety-Verification-0.0.1-SNAPSHOT.jar

COPY . .
ENTRYPOINT ["java", "-jar","LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]