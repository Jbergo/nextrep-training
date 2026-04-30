# Módulo Profesional Optativo

# Índice

1. [Descripción del módulo](#1-descripción-del-módulo)
2. [Contexto del proyecto](#2-contexto-del-proyecto)
3. [Objetivo del módulo MPO](#3-objetivo-del-módulo-mpo)
4. [Mejora estructural aplicada](#4-mejora-estructural-aplicada)
   - [Estructura aplicada](#estructura-aplicada)
   - [Responsabilidad de cada paquete](#responsabilidad-de-cada-paquete)
5. [Arquitectura por capas](#5-arquitectura-por-capas)
   - [5.1. Capa view](#51-capa-view)
   - [5.2. Capa service](#52-capa-service)
   - [5.3. Capa dao](#53-capa-dao)
   - [5.4. Capa model](#54-capa-model)
   - [5.5. Capa database](#55-capa-database)
6. [Diseño orientado a objetos](#6-diseño-orientado-a-objetos)
7. [Uso de JDBC seguro](#7-uso-de-jdbc-seguro)
8. [Validaciones y reglas de negocio](#8-validaciones-y-reglas-de-negocio)
9. [Flujo de menús](#9-flujo-de-menús)
10. [Funcionalidad extra o mejora visible](#10-funcionalidad-extra-o-mejora-visible)
    - [10.1. Separación de responsabilidades](#101-separación-de-responsabilidades)
    - [10.2. Código más mantenible](#102-código-más-mantenible)
    - [10.3. Mejor flujo de consola](#103-mejor-flujo-de-consola)
11. [Archivos relacionados](#12-archivos-relacionados)

---

## 1. Descripción del módulo

Este documento corresponde al módulo **MPO — Ampliación de Programación** del Proyecto Intermodular de 1.º DAW.

El objetivo de este módulo no es únicamente que la aplicación Java funcione, sino demostrar que el proyecto está construido con una estructura clara, mantenible y cercana a una forma de trabajo profesional.

En **Programación** se valora principalmente que la aplicación realice operaciones funcionales sobre la base de datos. En **MPO** se valora especialmente cómo está diseñado el código: organización por capas, separación de responsabilidades, uso correcto de clases, validaciones, flujo de menús y mantenibilidad general.

---

## 2. Contexto del proyecto

**NextRep Training** es una empresa ficticia de servicios de entrenamiento online. El proyecto incluye:

- Una web corporativa en HTML, CSS y JavaScript.
- Una base de datos relacional en MySQL/MariaDB.
- Una aplicación Java por consola conectada mediante JDBC.
- Documentación técnica del proyecto.

La aplicación Java permite gestionar información real del negocio:

- Clientes.
- Planes de entrenamiento.
- Solicitudes de contratación.
- Administradores.

El módulo MPO se centra en mejorar la calidad interna de esta aplicación Java.

---

## 3. Objetivo del módulo MPO

El objetivo principal del MPO es demostrar una mejora estructural visible respecto a una aplicación Java básica.

Para ello, la aplicación se organiza siguiendo una arquitectura por capas que permite separar responsabilidades y facilitar el mantenimiento del código.

Los objetivos concretos son:

- Aplicar Programación Orientada a Objetos de forma coherente.
- Evitar concentrar toda la lógica en una única clase `Main`.
- Separar el acceso a datos, la lógica de negocio y la interacción con el usuario.
- Utilizar clases modelo para representar las entidades del negocio.
- Usar DAOs para centralizar las operaciones con base de datos.
- Usar servicios para aplicar validaciones y reglas de negocio.
- Usar menús específicos para mejorar el flujo de consola.
- Mejorar la legibilidad, reutilización y mantenimiento del código.

---

## 4. Mejora estructural aplicada

La mejora principal del módulo MPO consiste en la **refactorización de la aplicación Java por capas**.

En lugar de tener una aplicación monolítica donde el menú, la lógica y las consultas SQL estén mezcladas, el proyecto se estructura en paquetes con responsabilidades diferenciadas.

### Estructura aplicada

```txt
app/
└── src/main/java/
    ├── dao/
    ├── database/
    ├── model/
    ├── service/
    ├── view/
    └── Main.java
```

### Responsabilidad de cada paquete

| Paquete | Responsabilidad |
|---|---|
| `model` | Contiene las clases del dominio: Cliente, Plan, Solicitud, Administrador y enums. |
| `dao` | Gestiona el acceso a la base de datos mediante JDBC. |
| `service` | Contiene la lógica de negocio y validaciones principales. |
| `view` | Contiene los menús de consola e interacción con el usuario. |
| `database` | Centraliza la configuración de conexión con la base de datos. |
| `Main` | Punto de entrada de la aplicación. |

---

## 5. Arquitectura por capas

La aplicación sigue una estructura lógica dividida en capas:

```txt
Usuario
  ↓
Menús de consola / view
  ↓
Servicios / service
  ↓
DAO / dao
  ↓
Base de datos MySQL/MariaDB
```

### 5.1. Capa `view`

La capa `view` se encarga de mostrar menús, leer datos por consola y llamar a los servicios correspondientes.

Ejemplos:

- `MainMenu`
- `ClienteMenu`
- `PlanMenu`
- `SolicitudMenu`

---

### 5.2. Capa `service`

La capa `service` se encarga de coordinar la lógica de negocio.

Ejemplos:

- Validar que los datos mínimos no estén vacíos.
- Comprobar que un email tenga un formato básico correcto.
- Evitar operaciones incoherentes.
- Llamar al DAO solo cuando los datos son válidos.

Ejemplos de clases:

- `ClienteService`
- `PlanService`
- `SolicitudService`

---

### 5.3. Capa `dao`

La capa `dao` contiene las operaciones directas contra la base de datos.

Aquí se utilizan:

- `Connection`
- `PreparedStatement`
- `ResultSet`
- Consultas SQL
- Mapeo de filas de base de datos a objetos Java

Ejemplos de clases:

- `ClienteDAO`
- `PlanDAO`
- `SolicitudDAO`

Esta capa permite que las consultas SQL estén separadas del menú de consola.

---

### 5.4. Capa `model`

La capa `model` representa las entidades principales del negocio mediante clases Java.

Ejemplos:

- `Cliente`
- `Plan`
- `Solicitud`
- `Administrador`

También puede incluir enums para controlar valores cerrados del sistema, como:

- Nivel del cliente.
- Estado de solicitud.
- Tipo de plan.

---

### 5.5. Capa `database`

La capa `database` o `config` centraliza la conexión JDBC.

Su finalidad es evitar repetir la configuración de conexión en varios sitios del proyecto.

Ejemplo de responsabilidad:

```java
public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
}
```

---

## 6. Diseño orientado a objetos

La aplicación aplica Programación Orientada a Objetos mediante:

- Clases que representan entidades reales del negocio.
- Atributos privados.
- Constructores.
- Métodos getter y setter cuando son necesarios.
- Métodos con responsabilidades concretas.
- Separación entre datos, lógica y presentación.
- Uso de enums para limitar valores válidos.

### Ejemplo conceptual

```txt
Cliente
├── idCliente
├── nombre
├── apellidos
├── email
├── telefono
├── nivel
├── objetivo
└── fechaAlta
```

La clase `Cliente` no debería conectarse a la base de datos ni mostrar menús. Solo representa información del dominio.

---

## 7. Uso de JDBC seguro

La aplicación utiliza JDBC para conectarse con la base de datos y realizar operaciones reales.

Buenas prácticas aplicadas:

- Uso de `PreparedStatement`.
- Separación de consultas SQL en la capa DAO.
- Manejo de excepciones SQL.
- Conversión de resultados (`ResultSet`) a objetos del modelo.
- Evitar concatenar directamente datos del usuario en consultas SQL.

Ejemplo conceptual:

```java
String sql = "SELECT * FROM clientes WHERE email = ?";

try (Connection connection = DatabaseConnection.getConnection();
     PreparedStatement statement = connection.prepareStatement(sql)) {

    statement.setString(1, email);
    ResultSet resultSet = statement.executeQuery();

    // Mapeo del resultado
}
```

---

## 8. Validaciones y reglas de negocio

Como mejora estructural, parte de las validaciones se gestionan desde la capa `service` y no directamente desde los menús.

---

## 9. Flujo de menús

La aplicación se organiza mediante un menú principal y submenús por entidad.

Ejemplo de flujo:

```txt
Menú principal
├── Gestión de planes
│   ├── Listar planes
│   └── Buscar planes por nivel
├── Gestión de clientes
│   ├── Listar clientes
│   ├── Buscar cliente por email
│   ├── Crear cliente
│   ├── Modificar cliente
│   └── Eliminar cliente
└── Gestión de solicitudes
    ├── Listar solicitudes
    ├── Buscar solicitudes por estado
    ├── Crear solicitud
    ├── Modificar solicitud
    └── Eliminar solicitud
```

Esta estructura mejora la usabilidad de la aplicación y evita que todo el flujo esté concentrado en una única clase.

---

## 10. Funcionalidad extra o mejora visible

La mejora visible del módulo MPO se puede resumir en tres puntos:

### 10.1. Separación de responsabilidades

Cada clase tiene una responsabilidad concreta:

- Los menús muestran opciones.
- Los servicios validan y coordinan.
- Los DAOs acceden a la base de datos.
- Los modelos representan datos.
- La clase de conexión centraliza JDBC.

### 10.2. Código más mantenible

La estructura permite modificar una parte del sistema sin romper el resto.

Ejemplos:

- Si cambia una consulta SQL, se modifica en el DAO.
- Si cambia una validación, se modifica en el Service.
- Si cambia el texto del menú, se modifica en la capa View.
- Si cambia la conexión, se modifica en DatabaseConnection.

### 10.3. Mejor flujo de consola

El usuario puede navegar por menús específicos en lugar de usar un único menú gigante. Esto mejora la claridad, reduce duplicidad y hace que la app sea más fácil de ampliar.

---

## 11. Archivos relacionados

```txt
docs/
└── mpo/
    └── README.md

diagrams/
├── uml.drawio
└── uml.png

app/
└── src/main/java/
    ├── dao/
    ├── database/
    ├── model/
    ├── service/
    ├── view/
    └── Main.java
```