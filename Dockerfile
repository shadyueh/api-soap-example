FROM amazoncorretto:8u342-alpine3.15-jre

# Cria grupo e usuário 'spring' para aplicação (secutity improving)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copia o executável da app para dentro do container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","./app.jar"]