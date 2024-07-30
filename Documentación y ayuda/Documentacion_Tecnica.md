# Manual Técnico - STARLIGHT

## Introducción
Starlight es un videojuego que busca ofrecer una experiencia de entretenimiento única y divertida.
En este manual técnico encontrará información detallada sobre la arquitectura, tecnologías y configuraciones necesarias para implementar el videojuego.

## Arquitectura del Sistema
Starlight consta de tres componentes principales:
1. **Backend y Frontend**: Desarrollado en Java Swing y AWT.
2. **Gestor de Datos**: Utiliza una base de datos SQL (MySQL).

## Requisitos Técnicos
1. **Backend**: JDK21
2. **Frontend**: JavaSwing
3. **Gestión de Datos**: MySQL
4. **Control de Versiones**: Git

## Implementación del Backend
### Configuración del Entorno
1. Instalar JDK 21.
2. Configurar NetBeans 20 como entorno de desarrollo.
3. Configurar la conexión a la base de datos MySQL utilizando JDBC 5.1.49

### Despliegue y Ejecución
1. Clonar el repositorio del proyecto desde GitHub Desktop.
2. Abrir el proyecto en NetBeans 20.

## Configuración de la Base de Datos
1. Dentro del package BD, copiar el script y pegarlo en Workbench, después ejecutar las querys para crear la BD.
![workbrench](https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/work.png)

2. Dentro del package Conexion, editar la contraseña por la de su máquina.
![Conexion](https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/conexion.png)

## Capturas de Pantalla y Descripcion

<div style="text-align: center;">
    <img src="https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/packbd.png" alt="Package BD">
    <br>
    <strong>Imagen:</strong> Package BD
</div>

![Package Starlight](https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/packstar.png)
**Imagen:** Package Starlight
