# === Build Stage ===
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# === Run Stage ===
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/*.jar ShaiTest.jar
EXPOSE 8080
CMD ["java", "-jar", "ShaiTest.jar"]