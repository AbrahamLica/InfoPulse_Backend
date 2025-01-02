# Usar uma imagem oficial do Java como base
FROM eclipse-temurin:17-jdk-alpine

# Configurar o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven/Gradle para o container
COPY target/*.jar app.jar

# Expor a porta que sua aplicação usa
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
