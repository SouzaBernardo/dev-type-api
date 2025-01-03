FROM gradle:jdk21 AS build
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

FROM openjdk:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/service.jar"]