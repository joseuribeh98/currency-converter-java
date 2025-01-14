# Conversor de Monedas en Java

## Descripción

Aplicación Java que permite convertir diferentes tipos de monedas utilizando tasas de cambio en tiempo real a través de una API. Este proyecto fue desarrollado como parte del programa ONE - Oracle Next Education.

## Sobre ONE - Oracle Next Education

Este proyecto forma parte del programa Oracle Next Education (ONE), una iniciativa de Oracle y Alura Latam que proporciona formación en tecnología y habilidades para el desarrollo profesional. Para más información, visita: <https://www.oracle.com/ar/education/oracle-next-education/>

## Características

- Conversión entre diferentes monedas en tiempo real
- Consumo de API de tasas de cambio
- Interfaz de consola intuitiva
- Manejo de datos JSON
- Filtrado de monedas específicas de Latinoamérica
- Historial de conversiones con marca de tiempo
- Visualización de últimas 5 conversiones realizadas

## Estructura del Proyecto

- Configuración del Ambiente Java
- Creación del Proyecto
- Consumo de la API
- Análisis de la Respuesta JSON
- Filtro de Monedas
- Interfaz de Usuario

## Requisitos del Sistema

### Software Necesario

- Java JDK 11 o superior - [Download Java LTS](https://adoptium.net/)
- Apache Maven 3.6.3 o superior
- Biblioteca Gson 2.10.1 o superior (gestionada por Maven)

### Configuración del Ambiente de Desarrollo

1. **Instalación de Java JDK**
   - Descarga Java JDK desde <https://adoptium.net/>
   - Instala siguiendo las instrucciones para tu sistema operativo
   - Verifica la instalación ejecutando `java -version` en la terminal

2. **Instalación de Maven**
   - Descarga Maven desde <https://maven.apache.org/download.cgi>
   - Sigue las instrucciones de instalación: <https://maven.apache.org/install.html>
   - Verifica la instalación ejecutando `mvn -version`

3. **Configuración de dependencias**
   El proyecto utilizará Maven para gestionar dependencias. Las principales dependencias se encuentran en el archivo `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
   </dependency>
   ```

## Instalación

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/[tu-usuario]/currency-converter-java.git
   ```

2. Navegar al directorio del proyecto:

   ```bash
   cd currency-converter-java
   ```

3. Compilar el proyecto con Maven:

   ```bash
   mvn clean install
   ```

## Uso

1. Ejecutar el programa:

   ```bash
   mvn exec:java
   ```

2. El programa mostrará un menú con las siguientes opciones:
   - Ver monedas disponibles
   - Realizar conversión
   - Ver historial de conversiones
   - Salir

3. Para realizar una conversión:
   - Seleccionar la opción 2
   - Ingresar la moneda de origen (ej: USD)
   - Ingresar la moneda de destino (ej: EUR)
   - Ingresar el monto a convertir

4. Monedas disponibles:
   - USD (Dólar estadounidense)
   - EUR (Euro)
   - GBP (Libra esterlina)
   - JPY (Yen japonés)
   - BRL (Real brasileño)
   - ARS (Peso argentino)
   - CLP (Peso chileno)
   - MXN (Peso mexicano)
   - PEN (Sol peruano)
   - COP (Peso colombiano)

## Contribución

1. Hacer un Fork del proyecto
2. Crear una rama para tu contribución (`git checkout -b feature/AmazingFeature`)
3. Commit de tus cambios (`git commit -m 'feat: Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.
