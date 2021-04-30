# proyectoAldeamo

Envío de una campana rápida desde Tellit, y posterior validación desde el módulo de reportes. Implementación en Java, de Page Object Model en Java, con Cucumber y JUnit4.

## Prerrequisitos

* Jdk1.8 o superior.

* Apache Maven 3.+.

* Docker 18.+

## Instalación

1. Clonar el proyecto, desde el repositorio en github.

2. Situarse en la carpeta del proyecto.

3. Ejecutar mvn install para instalar las dependencias.

```shell

mvn install 

```

## Ejecución

1. Dentro de la raíz del proyecto ejecutar el siguiente comando maven.

```shell

mvn clean test 

```
## Estructura del proyecto

```
src
└── test
    ├── java
    │   ├── features
    │   |   └── DownloadReport.feature
    │   |   └── DownloadSendMessageReport.feature
    │   |   └── ViewReports.feature
    │   ├── helpers
    │   |   └── Helpers.java
    │   └── pages
    │   |   └── smsReportPage.java
    │   |   └── LoginPage.java
    │   |   └── MainPage.java
    │   |   └── SmsPage.java
    │   └── runner
    │   |   └── RunCukesTest.java
    │   └── seleniumgluecode
    │   |   └── steps
    │   |      └── Report
    │   |      |   └── DownloadReport.java
    │   |      |   └── ViewReports.java
    │   |      |   └── VerifyReport.java
    │   |      └── sms
    │   |      |   └── SendMessage.java
    │   |      └── Hooks.java
    │   |      └── TestBase.java
    └── Resources
    │   ├── Chromedriver
    │   ├── Firefoxdriver
    .
    .
.
```

## Descripcion de carpetas:

|Ruta   |Descripcion    |
|-------|----------------|
|test\java\features\\\*.feature|Carpeta con todos los **archivos features** los cuales contienen los **Escenarios de prueba** |
|test\java\pages\\\*.java|Carpeta con todos los **PageObjects** que hacen match con los steps codificados en java|
|test\java\...\steps\\\*Steps.java|Carpeta con todos los **steps** los cuales hacen match con los escenarios de prueba en Gherkin|
|test\resources|Carpeta con los drives de Windons y Linux para la ejecucion en local |


## Ejecución desde Jenkins

Agregar los siguientes plugins a Jenkins para visualizar el reporte generado por el test.

* Cucumber reports (para la generación de los dashboars)

## Parametros leidos desde archivo Properties

Los parámetros necesarios para el test son suplidos desde el archivo "config.properties", el cual se encuentra en la siguiente ruta del proyecto:

```shell

src/test/config.properties

```

El archivo tiene las configuraciones básicas para ejecutar el test, como el ambiente (Preproducción, Producción) donde se van a realizan las pruebas, así como las credenciales de usuario, el mensaje a enviar y destinatarios.

