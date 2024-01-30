# Use a base image with JDK 21
FROM openjdk:21-jdk-slim

# Copy the JAR file to the container
COPY ./target/gsmarena-solvd-1.0-SNAPSHOT.jar /app/gsmarena-solvd.jar

# Set the working directory
WORKDIR /app

# Command to run the application when the container starts
CMD ["java", "-jar", "gsmarena-solvd.jar"]





