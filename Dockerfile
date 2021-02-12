FROM openjdk:8-jre-alpine as target
RUN mvn clean install
VOLUME /tmp
EXPOSE 10555
COPY target/LV-Safety-Verification-0.0.1-SNAPSHOT.jar LV-Safety-Verification-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar",'LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]