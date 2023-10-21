# Use a multi-stage build to compile the Java application and then run it.
# This way, you don't need Maven or the JDK installed on your host machine, just Docker.

# Stage 1: Build with Maven
FROM maven:3.8.3-openjdk-17 as build

WORKDIR /app

# Copy your source code and pom.xml into the image
COPY src ./src
COPY pom.xml .

# Run Maven to package your application
RUN mvn package

# Stage 2: Run the compiled Java application
FROM openjdk:17-jdk

# Create a volume point for caching and other needs
VOLUME /tmp

# Copy the compiled JAR file from the first stage
COPY --from=build /app/target/*.jar app.jar

# Command to run your Java application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
