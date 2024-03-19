# Use uma imagem base com Maven e JDK para compilar o projeto
FROM maven:3.8.1-jdk-11 AS build

# Copie os arquivos de configuração do Maven para um diretório temporário
COPY pom.xml /tmp/
COPY src /tmp/src/

# Defina o diretório de trabalho como o diretório temporário
WORKDIR /tmp/

# Compile o projeto usando o Maven
RUN mvn clean package

# Use uma imagem menor para a execução final
FROM openjdk:11-jre-slim

# Copie o artefato compilado do diretório de compilação para o diretório de trabalho
COPY --from=build /tmp/target/meu-projeto.jar /usr/app/meu-projeto.jar

# Defina o comando padrão para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "/usr/app/meu-projeto.jar"]
