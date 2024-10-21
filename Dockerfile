FROM alpine

# Install the latest version of OpenJDK 8
RUN apk update && \
    apk upgrade && \
    apk add --no-cache openjdk8

# Set environment variable for Java
ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"

# Copy the JAR file to the container
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
