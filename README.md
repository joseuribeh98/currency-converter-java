# Conversor de Monedas en Java

## Descripción

Aplicación Java que permite convertir diferentes tipos de monedas utilizando tasas de cambio en tiempo real a través de una API.

## Características

- Conversión entre diferentes monedas
- Consumo de API de tasas de cambio
- Interfaz de usuario intuitiva
- Manejo de datos JSON
- Filtrado de monedas específicas

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
- Biblioteca Gson 2.10.1 o superior
- Postman - Para pruebas de API
- IDE recomendado: IntelliJ IDEA (opcional)

### Configuración del Ambiente de Desarrollo

1. **Instalación de Java JDK**
   - Descarga Java JDK desde <https://adoptium.net/>
   - Instala siguiendo las instrucciones para tu sistema operativo
   - Verifica la instalación ejecutando `java -version` en la terminal

2. **Configuración de Gson**
   - El proyecto utilizará Maven para gestionar dependencias
   - La dependencia de Gson se agregará en el archivo `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
   </dependency>
   ```

3. **Instalación de Postman**
   - Descarga Postman desde <https://www.postman.com/downloads/>
   - Instala y crea una cuenta gratuita
   - Será utilizado para probar las APIs de conversión de monedas

4. **IDE (Opcional)**
   - Descarga IntelliJ IDEA desde <https://www.jetbrains.com/idea/download/>
   - Puedes usar la versión Community (gratuita) o Ultimate
   - Configura el JDK en el IDE después de la instalación

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

## Contribución

1. Hacer un Fork del proyecto
2. Crear una rama para tu contribución (`git checkout -b feature/AmazingFeature`)
3. Commit de tus cambios (`git commit -m 'feat: Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.
