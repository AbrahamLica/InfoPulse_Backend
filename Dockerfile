# Use a imagem do Maven como base para construir a aplicação
FROM maven:3.8.6-openjdk-17-slim AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie os arquivos do projeto
COPY . .

# Compile o projeto e gere o JAR
RUN mvn clean install -DskipTests

# Use a imagem do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR gerado pelo Maven
COPY --from=build /app/target/*.jar app.jar

# Exponha a porta
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
