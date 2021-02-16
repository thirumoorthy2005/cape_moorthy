FROM openjdk:8
WORKDIR '/capeelectric'
VOLUME /tmp
ADD target/LV-Safety-Verification-0.0.1-SNAPSHOT.jar LV-Safety-Verification-0.0.1-SNAPSHOT.jar
EXPOSE 8086
COPY . .
ENTRYPOINT ["java", "-jar","LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]