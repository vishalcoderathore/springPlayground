# Use the official maven/Java 17 image to create a build artifact.
# This is based on Debian and sets up OpenJDK 17 and Maven.
FROM maven:3.8.3-openjdk-17-slim AS build

# Set the current working directory inside the image
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml ./

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the local code to the container
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use OpenJDK 17 to run the application
FROM openjdk:17-slim

# Copy the jar file from the build image to the production image
COPY --from=build /app/target/*.jar app.jar

# Set the startup command to run your application
CMD ["java", "-jar", "/app.jar"]
