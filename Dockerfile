FROM openjdk:8-alpine3.9

ADD target/*.jar sbr.jar

ENTRYPOINT ["java", "-jar", "sbr.jar"]