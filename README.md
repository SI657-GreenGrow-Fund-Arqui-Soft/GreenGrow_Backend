# GreenGrow Backend

GreenGrow Backend es una suite de microservicios diseñada para la gestión eficiente de una plataforma de agricultura. Este proyecto incluye varios microservicios como `api-gateway`, `articles`, `courses`, `discovery-server`, `posts`, `profiles` Y `trends`

# Microservicios de GreenGrow Backend

- **`api-gateway`**:
  - El `api-gateway` actúa como un intermediario que maneja todas las solicitudes entrantes y las distribuye a los diferentes microservicios.

- **`articles`**:
  - Gestiona todo lo relacionado con la publicación y administración de artículos.

- **`courses`**:
  - El servicio `courses` se encarga de ofrecer y gestionar cursos educativos.

- **`discovery-server`**:
  - Utilizado por todos los microservicios para registrarse y localizar unos a otros. Este servidor facilita la comunicación entre microservicios permitiéndoles encontrar las direcciones de otros servicios de manera dinámica.

- **`posts`**:
  - El microservicio `posts` se encarga de la gestión de publicaciones hechas por los usuarios en la plataforma.

- **`profiles`**:
  - `profiles` administra los perfiles de usuario en la plataforma. Esto incluye la creación y actualización de información del perfil, gestión de preferencias y configuraciones de privacidad.

- **`trends`**:
  - El servicio `trends` analiza y proporciona información sobre las tendencias actuales en la agricultura, basándose en datos recopilados de varios servicios dentro de la plataforma.



## Prerrequisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- Java JDK 20 o superior
- Maven 17 o superior
- Git

## Configuración Inicial

Para obtener el proyecto y prepararlo para la ejecución, sigue estos pasos:

### 1. Clonar el Repositorio

Primero, necesitarás clonar el repositorio de GitHub a tu máquina local. Abre una terminal y ejecuta el siguiente comando:

```bash
git clone https://github.com/SI657-GreenGrow-Fund-Arqui-Soft/GreenGrow_Backend.git
```

Esto descargará una copia del proyecto en un directorio llamado GreenGrow_Backend.

## Construir el proyecto
Navega hasta el directorio principal del proyecto

```bash
cd GreenGrow_Backend
```

Antes de poder ejecutar los microservicios, necesitas construir el proyecto. Esto se realiza mediante Maven. Ejecuta los siguientes comandos:

1. Limpiar el Proyecto

Este comando limpiará el proyecto eliminando todos los archivos generados previamente en el proceso de construcción:

```bash
mvn clean
```

2. Compilar el Proyecto y Empaquetar

Después de limpiar el proyecto, compila el código y empaqueta los artefactos necesarios. Esto compilará el código fuente y empaquetará los resultados en archivos .jar para cada microservicio:

```bash
mvn install package
```

- `mvn install` instala los paquetes necesarios y compila el proyecto.
- `mvn package` compila el código fuente del proyecto y lo empaqueta en formato JAR ejecutable, generando archivos .jar que luego pueden ser ejecutados.

## Ejecutar los Microservicios

Una vez que el proyecto está construido y los archivos JAR están listos, puedes ejecutar todos los microservicios usando el `MultiApplicationRunner`. Puedes ejecutarlo desde el boton "RUN" incorporado en Intellij o si todavía estas en la raíz del proyecto y ejecuta:

```bash
java src/main/java/MultiApplicationRunner.java
```

## Tambien puede levantar la infrastructura en DOCKER
Para levantar toda la infraestructura de microservicios y RabbitMQ utilizando Docker Compose, sigue estos pasos:
1. Asegúrate de que tienes Docker y Docker Compose instalados. 
2. Navega al directorio raíz de tu proyecto donde se encuentra el archivo docker-compose.yml. 
3. Ejecuta el siguiente comando para construir y levantar todos los servicios:

```bash
docker-compose up --build
```
Este comando construirá las imágenes de Docker para cada uno de los microservicios definidos en tu archivo docker-compose.yml y levantará todos los contenedores necesarios, incluyendo el Eureka Server y RabbitMQ.

## Detener docker
```bash
docker-compose down
```

## Estado de los servicios

- Api Gateway: http://localhost:8000/{endpoint}
- Eureka Dashboard: http://localhost:8761/
- Rabbitmq Dashboard: http://localhost:15672/

## Acceso a los componentes del Sistema

Una vez que todos los microservicios estén en ejecución, podrás acceder a ellos a través de:
- Articles Microservice: http://localhost:8080/swagger-ui/index.html#/
- Courses Microservice: http://localhost:8081/swagger-ui/index.html#/
- Posts Microservice: http://localhost:8082/swagger-ui/index.html#/
- Profiles Microservice: http://localhost:8083/swagger-ui/index.html#/
- Trends Microservice: http://localhost:8084/swagger-ui/index.html#/

