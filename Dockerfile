FROM ubuntu:latest
LABEL authors="Asus"

ENTRYPOINT ["top", "-b"]
# 1. Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Копируем Gradle/Maven файлы
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Собираем JAR
RUN chmod +x mvnw
RUN ./mvnw -q -DskipTests package

# 2. Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app

# Копируем сборку из предыдущего контейнера
COPY --from=build /app/target/*.jar app.jar

# Render слушает порт из переменной $PORT
ENV PORT=8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
