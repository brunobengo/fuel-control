FROM amazoncorretto:17-alpine-jdk
COPY target/fuel-control-0.0.1-SNAPSHOT.jar fuel-control-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fuel-control-0.0.1-SNAPSHOT.jar"]