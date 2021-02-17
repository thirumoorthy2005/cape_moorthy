FROM maven:onbuild AS buildenv
FROM openjdk:8-jre-alpine as target
WORKDIR '/capeelectric'
VOLUME /tmp
COPY --from=buildenv ./LV-Safety-Verification-0.0.1-SNAPSHOT.jar lv-safety-verification.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar","LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]


#FROM openjdk:8
#ADD target/lv-safety-verification.jar lv-safety-verification.jar
#EXPOSE 8086
#ENTRYPOINT ["java", "-jar", "lv-safety-verification.jar"]