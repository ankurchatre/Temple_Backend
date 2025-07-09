# Use official Maven image to build the app
FROM maven:3.9.4-eclipse-temurin-17 as build

WORKDIR /app

# Copy the pom and source code
COPY pom.xml .
COPY src ./src

# Package the application (skip tests to speed it up)
RUN mvn clean package -DskipTests

# Use OpenJDK image to run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

