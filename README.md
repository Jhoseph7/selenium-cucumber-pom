# Selenium + Cucumber + POM + Allure

Proyecto práctico de automatización de pruebas web con arquitectura **Page Object Model**, escenarios **BDD** en Gherkin y reportes con evidencias en **Allure**.

Sitio bajo prueba: [Automation Test Store](https://automationteststore.com/), una tienda de práctica.

## Tecnologías

- Java 21
- Selenium WebDriver 4
- Cucumber (BDD, Gherkin en español)
- JUnit 5
- Maven
- Allure Report

## Estructura

```
src/test/java/com/jhoseph
├── configuraciones   → DriverFactory y lectura de configuración
├── contextos         → Contexto compartido por escenario (inyección con PicoContainer)
├── hooks             → Apertura y cierre del navegador, captura al fallar
├── paginas           → Page Objects (PaginaBase, PaginaLogin, PaginaCuenta)
├── runners           → Ejecutor de Cucumber
└── steps             → Definición de los pasos
src/test/resources
└── features          → Escenarios en Gherkin
```

## Qué incluye

- Page Object Model con una clase base que centraliza las esperas explícitas.
- Escenarios de login: caso correcto, contraseña incorrecta y esquema con varios datos inválidos.
- Captura de pantalla automática en Allure cuando un escenario falla.
- Trazabilidad con etiquetas de épica, historia, severidad e ID de caso de prueba.
- Credenciales fuera del código (archivo local o variables de entorno).

## Requisitos

- JDK 21 o superior
- Google Chrome
- Maven (o el de IntelliJ)

## Configuración

Copia `src/test/resources/config.example.properties` como `src/test/resources/config.properties` y pon los datos de una cuenta de prueba creada en la tienda. Ese archivo está en `.gitignore` y no se sube al repositorio.

Alternativa: definir las variables de entorno `USUARIO_VALIDO` y `CONTRASENA_VALIDA`.

## Ejecución

Desde IntelliJ: ejecuta la clase `RunCucumberTest`.

Desde la terminal:

```
mvn clean test
```

## Reporte de Allure

```
npm install -g allure
allure generate target/allure-results
allure open allure-report
```