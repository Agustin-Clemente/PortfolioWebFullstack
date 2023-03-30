FROM amazoncorretto:11-alpine-jdk
MAINTAINER agustin-clemente
COPY target/MiPortfolio-0.0.1-SNAPSHOT.jar portfolio.jar
ENTRYPOINT ["java","-jar","/portfolio.jar"]
