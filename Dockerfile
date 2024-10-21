FROM openjdk:8-jre-slim

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file into the container
COPY *.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
