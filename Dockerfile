FROM maven:3.6.0-jdk-8-alpine as build
WORKDIR /app

COPY . .

WORKDIR /app/lv-safety-verification

RUN mvn clean package -DskipTests=true

FROM openjdk:8

VOLUME /tmp
COPY --from=build /app/lv-safety-verification/target/*.jar ./
EXPOSE 8086
COPY . .
ENTRYPOINT ["java", "-jar","/app/LV-Safety-Verification-0.0.1-SNAPSHOT.jar"]