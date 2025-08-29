# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container named /app and rename it to my-spring-app

# Liten notering, se till att den använder .jar och inte plain. Det är viktigt
# Annars kommer filen ej att köras
COPY build/libs/WebService_Uppgifter_Lektion_5-0.0.1-SNAPSHOT.jar /app/my-spring-app.jar

# Expose the port that the application will run on (Must reflect Spring Boot's Port)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "/app/my-spring-app.jar"]
