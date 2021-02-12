FROM openjdk:8-jre-alpine
VOLUME /tmp
EXPOSE 10555
ADD target/LV-Safety-Verification-0.0.1-SNAPSHOT.jar LV-Safety-Verification-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar",'LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]