# Use official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy everything from your project folder into the container
COPY . .

# Grant execute permissions to mvnw if not already
RUN chmod +x mvnw

# Build the app (skipping tests for speed)
RUN ./mvnw clean package -DskipTests

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/*.jar"]
