# Banco Digital API

## Descripción
Este proyecto es un sistema de gestión de transacciones bancarias desarrollado con Spring WebFlux implementando 
arquitectura limpia. La aplicación permite registrar usuarios, crear cuentas, realizar transacciones, y consultar 
información detallada de transacciones.


## Requisitos & Tecnologías

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17?er=221886)
- [Gradle](https://gradle.org/)
- [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Mongo DB](https://www.mongodb.com/es)
- [Swagger](https://swagger.io/)


## Instalación
Pasos para instalar las dependencias y el proyecto.

```bash
# Clona este repositorio
git clone https://github.com/dev-elliotesco/digital-bank-clean-architecture-api.git

# Entra en el directorio del proyecto
cd digital-bank-clean-architecture-api

# Compila el proyecto usando Gradle
./gradlew build

```


## Configuración

1. Antes de ejecutar el proyecto, asegúrate de tener una base de datos MongoDB en ejecución
   y de configurar las siguientes variables de entorno con las credenciales correctas de la base de datos:

- `PORT`: El puerto en el que se ejecutará la aplicación.
- `DB_HOST`: La dirección IP o el nombre de host de tu base de datos. Por ejemplo, `localhost`.
- `DB_NAME`: El nombre de la base de datos. Por ejemplo, `bank_db`.
- `DB_USER`: El nombre de usuario de tu base de datos. Por ejemplo, `root`.
- `DB_PASSWORD`: La contraseña de tu base de datos.

Por ejemplo, puedes definir las variables de entorno en tu sistema operativo o en tu IDE. Si estás
utilizando IntelliJ IDEA, puedes definir las variables de entorno en la configuración de tu
Run/Debug Configuration.


## Ejecución
Pasos para ejecutar el proyecto.

### Localmente:

```bash
# Comando para iniciar el proyecto usando Gradle
./gradlew bootRun
```

```bash
# O ejecutando el JAR directamente
java -jar build/libs/bank-0.0.1-SNAPSHOT.jar
```
Para generar el JAR:

```bash
# Generando el JAR
# Nota: Este comando compila el código, ejecuta las pruebas y genera el JAR
/gradlew build
```
Documentación de Swagger:

Una vez que la aplicación esté en ejecución, puedes acceder a la documentación de Swagger en la siguiente URL:

```
http://localhost:8080/swagger-ui.html
```


## Autor
- Elliot Escovitch - [Github](https://github.com/dev-elliotesco)
- [LinkedIn](https://www.linkedin.com/in/elliot-escovitch-580007205/)
- Correo electrónico: dev.elliot.escovitch@gmail.com

