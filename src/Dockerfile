# Define la imagen base de Java
FROM openjdk:latest

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos Java al contenedor
COPY . /app/

# Compila los archivos Java
RUN javac *.java

# Expone el puerto utilizado por RMI
EXPOSE 1099

# Comando para ejecutar el servidor RMI
CMD ["java", "ServidorRMI"]
