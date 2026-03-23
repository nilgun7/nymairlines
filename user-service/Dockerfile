# 1. Aşama: Build (Maven ile paketi oluşturma)
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Aşama: Run (Sadece gerekli olan jar dosyasını çalıştırma)
FROM amazoncorretto:21.0.2-alpine3.19
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]