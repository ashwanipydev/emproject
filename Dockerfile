# Use the official Maven image to build the app
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy pom.xml and install dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn package -DskipTests

# Use the official OpenJDK image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/emproject-0.0.1-SNAPSHOT.jar .

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run the app
ENTRYPOINT ["java", "-jar", "/app/emproject-0.0.1-SNAPSHOT.jar"]
