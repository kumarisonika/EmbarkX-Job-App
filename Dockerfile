# 1️⃣ Use Java 17 (stable for Spring Boot)
FROM eclipse-temurin:17-jdk
# install postgres server and enable postgre server as a service
# configure creds
# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy jar from your machine into container
COPY target/myJobApp-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Expose Spring Boot port
EXPOSE 8080

# 5️⃣ Command to run when container starts
ENTRYPOINT ["java", "-jar", "app.jar"]


#  /Users/sonika/Documents/projects/myJobApp/target/myJobApp-0.0.1-SNAPSHOT.jar.original
