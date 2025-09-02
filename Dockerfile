# ---------- Stage 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -e -DskipTests package

# ---------- Stage 2: Run ----------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

ENV JAVA_OPTS=""
ENV PORT=8080

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD sh -c 'java $JAVA_OPTS -jar app.jar --server.port=${PORT}'
