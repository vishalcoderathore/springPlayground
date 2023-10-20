# Build phase
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# Intermediate layer for wait-for-it script
FROM debian:bullseye-slim as wait-for-it
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/vishnubob/wait-for-it.git

# Final image
FROM openjdk:17-slim
COPY --from=build /app/target/*.jar app.jar
COPY --from=wait-for-it /wait-for-it/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
CMD ["/bin/sh", "-c", "./wait-for-it.sh mysql-container:3306 -- java -jar /app.jar"]
