# ./gradlew clean assemble
# mkdir resteasy-jdk/build/docker
# cp resteasy-jdk/Dockerfile resteasy-jdk/build/distributions/resteasy-jdk-1.0-SNAPSHOT.tar resteasy-jdk/build/docker/
# cd resteasy-jdk/build/docker

# docker build --rm --tag=vmj0/jaxrs-se-example:resteasy-jdk .

# docker run --rm --read-only -p 9000:9000 --name=jaxrs-se-example vmj0/jaxrs-se-example:resteasy-jdk

# start from a small Java 7 base image
FROM openjdk:7-jre-alpine

# gradle generated start script has Bashism in it
RUN apk add --update bash && rm -rf /var/cache/apk/*

# extract the distribution
ADD resteasy-jdk-1.0-SNAPSHOT.tar /

# when "docker running", run the start script
CMD ["/bin/bash", "/resteasy-jdk-1.0-SNAPSHOT/bin/resteasy-jdk"]
