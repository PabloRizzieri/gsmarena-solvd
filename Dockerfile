# Use a base image with the Java 11 runtime environment
FROM openjdk:11-jre-slim

# Copy the JAR file of your application into the container
COPY ./target/gsmarena-solvd-1.0-SNAPSHOT.jar /app/gsmarena-solvd.jar

# Set the working directory
WORKDIR /app

# Command to run the application when the container starts
CMD ["java", "-jar", "gsmarena-solvd.jar"]




