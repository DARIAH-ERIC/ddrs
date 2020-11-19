FROM maven:3-jdk-8 as build
MAINTAINER yoann.moranville@gmail.com

WORKDIR /opt/src/app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn -DskipTests package

FROM openjdk:8-jdk-alpine

WORKDIR /opt/ddrs
COPY --from=build /opt/src/app/target/ddrs.jar ./ddrs.jar

EXPOSE 8080
CMD ["java", "-jar", "ddrs.jar"]