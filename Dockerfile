FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /usr/local/test/pom.xml
COPY src /usr/local/test/src
WORKDIR /usr/local/test
RUN ["mvn", "clean", "test", "-Dbrowser=<browser>", "-DlocalIpAddress=<your_local_ip_address>", "-Ppodium"]