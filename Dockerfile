# Use a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Copie o arquivo JAR para o contêiner
COPY target/chat-0.0.1-SNAPSHOT.jar /app.jar

# Defina o comando de entrada para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Exponha a porta 8080 (se necessário)
EXPOSE 8080
