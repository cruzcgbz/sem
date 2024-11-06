# Use the official OpenJDK image as the base
FROM openjdk:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target directory to the container
COPY target/seMethods-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

# Define the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
