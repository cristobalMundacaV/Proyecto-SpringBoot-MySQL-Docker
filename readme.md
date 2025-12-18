# Etapa 4 — Backend con Spring Boot, MySQL y Docker

# Descripción del proyecto

Este proyecto corresponde a la etapa final de un proceso de formación profesional autodirigido, orientado al desarrollo backend en un entorno real y reproducible.

En esta etapa, la aplicación desarrollada previamente con Spring Boot fue llevada a un entorno contenerizado utilizando Docker, integrando el backend y la base de datos bajo una única orquestación. Esto permite eliminar dependencias locales y configuraciones manuales.

El resultado es una aplicación que puede ser ejecutada por cualquier persona, en cualquier equipo, utilizando un solo comando.

# Objetivo principal

Los objetivos de esta etapa son ejecutar la aplicación en un entorno reproducible, contenerizar el backend con Docker, integrar el backend y la base de datos mediante Docker Compose, utilizar variables de entorno para la configuración de datos sensibles, automatizar el levantamiento completo del sistema y documentar todo el proceso de forma clara y profesional.

# Tecnologías utilizadas

Java 21  
Spring Boot 4  
Spring Data JPA  
Hibernate  
MySQL 8  
Maven  
Docker  
Docker Compose  
Git y GitHub  
Postman  

# Arquitectura base

La aplicación sigue una arquitectura en capas, separando responsabilidades para facilitar la mantenibilidad y escalabilidad del sistema. El flujo general es: cliente, controlador, servicio, repositorio y base de datos.

En el entorno Docker, la arquitectura queda compuesta por un contenedor para la aplicación Spring Boot, un contenedor para la base de datos MySQL y una red interna gestionada por Docker Compose que permite la comunicación entre ambos servicios.

# Configuración del entorno

## Requisitos previos

Para ejecutar el proyecto no es necesario tener Java ni MySQL instalados de forma local. Los únicos requisitos son Docker, Docker Compose y Git.

## Variables de entorno

La aplicación utiliza variables de entorno para la configuración de la base de datos. Estas variables son BD_URL, BD_USER y BD_PASSWORD.

Dichas variables se definen en el archivo docker-compose.yml y son consumidas por Spring Boot a través del archivo application.properties.

## Configuración de application.properties

La configuración principal define el nombre de la aplicación, la conexión a la base de datos mediante variables de entorno, el comportamiento de Hibernate para la creación y actualización de tablas, el dialecto de MySQL y el puerto de ejecución del servidor.

## Dockerfile del backend

El backend se construye a partir de una imagen oficial de Java basada en eclipse-temurin versión 21. El proceso copia el archivo JAR generado por Maven, expone el puerto 8080 y ejecuta directamente la aplicación Spring Boot dentro del contenedor.

## Docker Compose

El archivo docker-compose.yml se encarga de orquestar el sistema completo. Define un servicio para la aplicación Spring Boot y otro para la base de datos MySQL. Además, centraliza las variables de entorno y utiliza un healthcheck para asegurar que la base de datos esté completamente operativa antes de iniciar el backend.

## Ejecución del proyecto

Para ejecutar el proyecto, primero se debe clonar el repositorio y luego posicionarse en el directorio principal del proyecto. Posteriormente, se utiliza el comando docker-compose up --build, el cual se encarga de construir la imagen del backend, inicializar la base de datos MySQL, crear la base de datos y levantar la aplicación Spring Boot de forma automática.

## Verificación de funcionamiento

Una vez levantado el sistema, el backend queda disponible en http://localhost:8080. La base de datos MySQL se ejecuta dentro de un contenedor y las tablas son creadas automáticamente por Hibernate. El sistema cuenta con un CRUD completamente funcional.

Los endpoints fueron probados exitosamente utilizando Postman, incluyendo operaciones de inserción, consultas GET, actualizaciones y eliminaciones.

## Funcionalidades implementadas

El sistema cuenta con las entidades Producto y Categoría, con una relación ManyToOne entre ambas. Se implementaron endpoints REST que permiten listar registros, obtenerlos por ID, crear nuevos elementos, actualizar registros existentes y eliminarlos.

## Automatización

Gracias al uso de Docker Compose, todo el sistema puede levantarse con un solo comando. No existen configuraciones manuales ocultas, el proyecto no depende del sistema operativo y es completamente reproducible en cualquier entorno.

## Estado del proyecto

Backend contenerizado correctamente.  
Base de datos integrada mediante Docker.  
Variables de entorno configuradas.  
Dockerfile funcional.  
Docker Compose operativo.  
Automatización completa.  
Documentación clara y estructurada.  

# Conclusión

Este proyecto representa un entorno backend de nivel profesional, preparado para ejecución real, pruebas y futuros despliegues.

La etapa de Docker consolida los conocimientos previos y los lleva a un contexto práctico y reproducible, alineado con estándares utilizados en la industria del desarrollo de software.
