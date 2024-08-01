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

### Requisitos Mínimos:
- Procesador: Intel Core i3 o equivalente
- Memoria RAM: 4 GB
- Almacenamiento: 500 MB de espacio disponible
- Resolución de Pantalla: 1280x720 píxeles

### Requisitos Recomendados:
- Procesador: Intel Core i5 o superior
- Memoria RAM: 8 GB
- Almacenamiento: 1 GB de espacio disponible
- Tarjeta Gráfica: NVIDIA GeForce GTX 750 o superior
- Resolución de Pantalla: 1920x1080 píxeles

### Dependencias y Herramientas de Desarrollo
- Entorno de Desarrollo Integrado (IDE): IntelliJ IDEA, Eclipse, o NetBeans (solo para desarrollo)
- Control de Versiones: Git (solo para desarrollo)
- Herramientas de Compilación: Ant
- Sistemas de Gestión de Bases de Datos: SQL (MySQL)

### Base de Datos
- Sistema de Gestión de Bases de Datos (SGDB): SQL
- Requisitos de Almacenamiento: Espacio suficiente en disco para la base de datos (dependiendo de la cantidad de datos que se manejen)


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
<div style="text-align: center;">
    <img src="https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/work.png" alt = "Workbrench">
    <br>
    <strong>Imagen:</strong> Workbench
</div>
<br><br>

2. Dentro del package Conexion, editar la contraseña por la de su máquina.

<div style="text-align: center;">
    <img src= https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/conexion.png alt="Conexion">
    <br>
    <strong>Imagen:</strong> Conexion
</div>
<br><br>

## Capturas de Pantalla y Descripcion

<div style="text-align: center;">
    <img src="https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/packbd.png" alt="Package BD">
    <br>
    <strong>Imagen:</strong> Package BD
</div>
<br><br>

<div style="text-align: center;">
    <img src="https://github.com/davco0720/Starlight/blob/main/Documentaci%C3%B3n%20y%20ayuda/img_tec/packstar.png">
    <br>
    <strong>Imagen:</strong> Package Starlight
</div>

##  Conclusiones y Recomendaciones
### Conclusiones

- **Desempeño del Juego:** El juego ha demostrado un excelente rendimiento, haciendo uso de diversas librerías como el JDK 21 y la base de datos SQL. Sin embargo, existe un margen de optimización para mejorar aún más la experiencia del usuario.
<br>

- **Compatibilidad y Usabilidad:** El juego ha sido diseñado para ser compatible con diversas configuraciones de hardware sin necesidad de conexión a internet. La implementación de MySQL y JDBC-5.1.49 permite una gestión de las puntuaciones del juego.
<br>

- **Calidad Gráfica y de Interfaz:** A través del uso de Java Swing, el juego presenta una interfaz gráfica, aunque podrían implementarse diversas mejoras en el diseño y la estructuración.
<br>

- **Escalabilidad:** El diseño del juego ha sido estructurado para ser compatible con futuras actualizaciones, permitiendo la incorporación de nuevos niveles, personajes y funcionalidades sin requerir una reescritura significativa del código base.
<br>

- **Documentación Técnica:** La creación de un manual técnico y de usuario detallado son de suma importancia dentro y fuera del juego. Este manual proporciona una guía para futuros desarrolladores y garantiza una fácil ejecución del juego.
<br>
<br>

### Recomendaciones

- **Optimización de Recursos y Rendimiento:** Se recomienda realizar pruebas exhaustivas del rendimiento del juego para identificar posibles errores y optimizar el uso de los recursos. 
<br>

- **Ampliación del Contenido del Juego:** Se sugiere desarrollar y añadir nuevos niveles, personajes y modos de juego para aumentar la duración del juego. Esto tiene como objetivo que el usuario disfrute e indague en todas las funcionalidades.
<br>

- **Mejora de la Interfaz de Usuario (UI):** La actualización de la interfaz gráfica puede hacer que el juego sea visualmente más atractivo. Un rediseño de interfaz centrado en el usuario puede mejorar la experiencia del juego.
<br>

- **Implementación de Funcionalidades de Guardado y Carga:** Integrar funcionalidades para guardar y cargar partidas. Esto tiene como objetivo que los jugadores puedan retomar el juego desde el punto donde lo dejaron, mejorando así la comodidad del usuario.
<br>

- **Pruebas y Opiniones de Usuarios:** Es necesario realizar pruebas exhaustivas con un grupo diverso de usuarios para recoger opiniones y detectar posibles errores o áreas de mejora. Las pruebas de usabilidad y la incorporación de las sugerencias de los jugadores pueden llevar a un producto final más pulido y satisfactorio.

