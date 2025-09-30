FROM maven:3.9.11-amazoncorretto-24 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:24

WORKDIR /app

COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar ./my-app.jar

ENTRYPOINT ["java", "-jar", "my-app.jar"]
