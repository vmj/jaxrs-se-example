# docker build --rm --tag=vmj0/jaxrs-se-example:jersey-jdk .
# docker run --rm --read-only -p 9000:9000 --name=jaxrs-se-example vmj0/jaxrs-se-example:jersey-jdk
FROM openjdk:7-jre-alpine

# gradle generated start script has Bashism in it
RUN apk add --update bash && rm -rf /var/cache/apk/*

# Extract the distribution
ADD jersey-jdk-1.0-SNAPSHOT.tar /

# Run the start script
CMD ["/bin/bash", "/jersey-jdk/bin/jersey-jdk"]
