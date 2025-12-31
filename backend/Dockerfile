# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml only to download dependencies first (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy all source code
COPY src ./src

# Build the project (skip tests)
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy jar from build stage (auto detect the jar name)
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run Spring Boot with prod profile
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
