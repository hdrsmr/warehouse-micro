FROM openjdk:8-jdk-alpine

FROM  mysql

COPY target/pegawai-app-0.0.1-SNAPSHOT.jar /app/pegawai-docker.jar

CMD ["java", "-jar", "/app/pegawai-docker.jar"]