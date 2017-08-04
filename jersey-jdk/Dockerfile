# ./gradlew clean assemble
# mkdir jersey-jdk/build/docker
# cp jersey-jdk/Dockerfile jersey-jdk/build/distributions/jersey-jdk-1.0-SNAPSHOT.tar jersey-jdk/build/docker/
# cd jersey-jdk/build/docker

# docker build --rm --tag=vmj0/jaxrs-se-example:jersey-jdk .

# docker run --rm --read-only -p 9000:9000 --name=jaxrs-se-example vmj0/jaxrs-se-example:jersey-jdk

# start from a small Java 8 base image
FROM openjdk:8-jre-alpine

# extract the distribution
ADD jersey-jdk-1.0-SNAPSHOT.tar /

# when "docker running", run the start script
CMD ["/jersey-jdk-1.0-SNAPSHOT/bin/jersey-jdk"]
