# Etapa de construcción
FROM alpine:latest AS build

# Instala OpenJDK y otras dependencias
RUN apk update && apk add openjdk17 bash

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos necesarios para construir el proyecto
COPY . .
RUN chmod +x ./gradlew

# Compila el archivo .jar sin ejecutar tests
RUN ./gradlew bootJar --no-daemon

# Etapa de ejecución
FROM openjdk:17-alpine

# Establece el puerto de exposición
EXPOSE 9000

# Copia el .jar generado desde la etapa de build
COPY --from=build /app/build/libs/mutantes-0.0.1-SNAPSHOT.jar /app/app.jar

# Comando de inicio de la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
