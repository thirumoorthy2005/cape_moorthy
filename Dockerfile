FROM maven:onbuild AS buildenv

FROM openjdk:8-jre-alpine as target

VOLUME /tmp
COPY --from=buildenv target/LV-Safety-Verification-0.0.1-SNAPSHOT.jar LV-Safety-Verification-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["./wait-for-it.sh", "lv-inspection-db:3306", "--", "java", "-jar",'LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]