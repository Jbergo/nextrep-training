# Arquitectura de la aplicación Java — NextRep Training

## Índice

1. [Enfoque técnico](#1-enfoque-técnico)
2. [Estructura del proyecto Java](#2-estructura-del-proyecto-java)
3. [Descripción de capas](#3-descripción-de-capas)

   3.1. [Paquete `config`](#31-paquete-config)

   3.2. [Paquete `model`](#32-paquete-model)

   3.3. [Capa DAO](#33-capa-dao)

   3.4. [Capa Service](#34-capa-service)

   3.5. [Capa UI](#35-capa-ui)

   3.6. [Clase `Main`](#36-clase-main)
   
4. [Flujo funcional resumido](#4-flujo-funcional-resumido)

---

## 1. Enfoque técnico

La aplicación se ha diseñado con una **arquitectura por capas**, con separación de responsabilidades para que el código sea más mantenible y legible.

Flujo general de trabajo:

```text
UI -> Service -> DAO -> DBConnection -> Base de datos
```

Este enfoque permite:

- Separar la interacción con el usuario de la lógica de negocio.
- Evitar mezclar SQL con menús de consola.
- Organizar el proyecto de forma profesional.
- Facilitar la validación, el mantenimiento y futuras ampliaciones.

## 2. Estructura del proyecto Java

La estructura prevista de la aplicación es la siguiente:

```text
src/main/java/
├── config/
│   └── DBConnection.java
├── model/
│   ├── Cliente.java
│   ├── Plan.java
│   ├── Solicitud.java
│   ├── Administrador.java
│   ├── Estado.java
│   ├── Nivel.java
│   └── Personalizacion.java
├── dao/
│   ├── ClienteDAO.java
│   ├── PlanDAO.java
│   ├── SolicitudDAO.java
│   └── AdministradorDAO.java
├── service/
│   ├── ClienteService.java
│   ├── PlanService.java
│   ├── SolicitudService.java
│   └── AdministradorService.java
├── ui/
│   ├── MainMenu.java
│   ├── ClienteMenu.java
│   ├── PlanMenu.java
│   └── SolicitudMenu.java
└── Main.java
```

---

## 3. Descripción de capas

### 3.1. Paquete `config`

Contiene la configuración de acceso a base de datos.

#### `DBConnection`
Responsabilidades:

- Centralizar la conexión con MySQL mediante JDBC.
- Gestionar la URL, usuario y contraseña de acceso.
- Proporcionar una conexión reutilizable a las clases DAO.
- Encapsular la creación de la conexión para no repetir lógica en toda la aplicación.

Responsabilidad principal:

```text
obtener una conexión válida con la base de datos
```

### 3.2. Paquete `model`

Contiene las clases del dominio del negocio y los tipos enumerados que representan datos controlados.

#### Clases principales

##### `Cliente`
Representa a una persona que solicita o contrata un plan.

Atributos principales:

- `idCliente`
- `nombre`
- `apellidos`
- `email`
- `telefono`
- `nivel`
- `objetivo`
- `fechaAlta`

##### `Plan`
Representa un servicio o programación de entrenamiento ofrecida por NextRep Training.

Atributos principales:

- `idPlan`
- `nombre`
- `tipo`
- `nivelRequerido`
- `objetivo`
- `duracionSemanas`
- `frecuenciaSesiones`
- `duracionSesion`
- `personalizacion`
- `descripcion`
- `paraQuien`
- `precio`
- `activo`

##### `Solicitud`
Representa una solicitud de contratación de un plan realizada por un cliente.

Atributos principales:

- `idSolicitud`
- `idCliente`
- `idPlan`
- `idAdmin`
- `fechaSolicitud`
- `estado`
- `comentariosCliente`
- `notasInternas`

##### `Administrador`
Representa al usuario interno que gestiona solicitudes o consulta información administrativa.

Atributos principales:

- `idAdmin`
- `nombre`
- `apellidos`
- `email`

#### Enumeraciones del modelo

##### `Estado`
Valores sugeridos:

- `PENDIENTE`
- `APROBADA`
- `CANCELADA`

##### `Nivel`
Valores sugeridos:

- `PRINCIPIANTE`
- `INTERMEDIO`
- `AVANZADO`

##### `Personalizacion`
Valores sugeridos:

- `BAJA`
- `MEDIA`
- `ALTA`

### 3.3. Capa DAO

El paquete `dao` se encarga del acceso a datos.

Esta capa:

- Ejecuta sentencias SQL.
- Usa `PreparedStatement` para consultas seguras.
- Transforma filas de la base de datos en objetos Java.
- No contiene lógica de menús.
- No contiene interacción directa con el usuario.

#### Clases principales

##### `ClienteDAO`
Responsabilidades:

- Insertar clientes.
- Listar clientes.
- Buscar clientes por email.
- Actualizar clientes.
- Eliminar clientes.

Métodos representativos:

- `findAll()`
- `findByEmail(String email)`
- `save(Cliente cliente)`
- `update(Cliente cliente)`
- `deleteById(int idCliente)`

##### `PlanDAO`
Responsabilidades:

- Listar planes.
- Filtrar planes por nivel.
- Consultar planes activos.
- Recuperar un plan concreto cuando sea necesario.

Métodos representativos:

- `findAll()`
- `findByLevel(Nivel nivel)`
- `findActivos()`
- `findById(int idPlan)`

##### `SolicitudDAO`
Responsabilidades:

- Insertar solicitudes.
- Listar solicitudes.
- Buscar solicitudes por estado.
- Buscar solicitudes por cliente.
- Actualizar solicitudes.
- Eliminar solicitudes.
- Ejecutar consultas con JOIN para mostrar datos combinados.

Métodos representativos:

- `findAll()`
- `findByState(Estado estado)`
- `findByClient(Cliente cliente)`
- `save(Solicitud solicitud)`
- `update(Solicitud solicitud)`
- `deleteById(int idSolicitud)`

##### `AdministradorDAO`
Responsabilidades:

- Consultar información del administrador.
- Listar administradores si se decide mantener esta opción.

Métodos representativos:

- `findAll()`
- `findById(int idAdmin)`

### 3.4. Capa Service

El paquete `service` actúa como capa intermedia entre `ui` y `dao`.

Esta capa se encarga de:

- Coordinar operaciones del negocio.
- Validar datos antes de llamar al DAO.
- Encapsular reglas de negocio simples.
- Ofrecer métodos orientados a casos de uso, no a SQL.

#### Clases principales

##### `ClienteService`
Responsabilidades:

- Listar clientes.
- Buscar clientes por email.
- Registrar nuevos clientes.
- Modificar clientes.
- Eliminar clientes.

Métodos representativos:

- `listarClientes()`
- `buscarPorEmail(String email)`
- `nuevoCliente(Cliente cliente)`
- `modificarCliente(Cliente cliente)`
- `eliminarCliente(int idCliente)`

##### `PlanService`
Responsabilidades:

- Listar planes disponibles.
- Filtrar planes por nivel.
- Obtener planes activos.

Métodos representativos:

- `listarPlanes()`
- `buscarPorNivel(Nivel nivel)`
- `listarPlanesActivos()`

##### `SolicitudService`
Responsabilidades:

- Listar solicitudes.
- Buscar solicitudes por estado.
- Buscar solicitudes de un cliente.
- Crear nuevas solicitudes.
- Modificar solicitudes.
- Eliminar solicitudes.

Métodos representativos:

- `listarSolicitudes()`
- `buscarPorEstado(Estado estado)`
- `buscarPorCliente(Cliente cliente)`
- `nuevaSolicitud(Solicitud solicitud)`
- `modificarSolicitud(Solicitud solicitud)`
- `eliminarSolicitud(int idSolicitud)`

##### `AdministradorService`
Responsabilidades:

- Consultar la información del administrador.
- Listar administradores si se implementa la opción correspondiente.

Métodos representativos:

- `listarAdmin()`
- `obtenerAdminPorId(int idAdmin)`

### 3.5. Capa UI

El paquete `ui` contiene los menús de consola y la interacción con el usuario.

Esta capa:

- Muestra opciones por pantalla.
- Recoge datos introducidos por teclado.
- Llama a la capa `service`.
- No ejecuta SQL.
- No gestiona directamente conexiones JDBC.

#### Clases principales

##### `MainMenu`
Responsabilidades:

- Mostrar el menú principal.
- Redirigir al usuario a los distintos submenús.
- Ofrecer acceso centralizado a la aplicación.

##### `ClienteMenu`
Responsabilidades:

- Listar clientes.
- Buscar por email.
- Dar de alta nuevos clientes.
- Modificar clientes.
- Eliminar clientes.

##### `PlanMenu`
Responsabilidades:

- Listar planes.
- Filtrar planes por nivel.
- Mostrar información útil del catálogo.

##### `SolicitudMenu`
Responsabilidades:

- Listar solicitudes.
- Buscar por estado.
- Crear nuevas solicitudes.
- Modificar solicitudes.
- Eliminar solicitudes.

### 3.5. Clase `Main`

La clase `Main` es el punto de entrada de la aplicación.

Responsabilidades:

- Iniciar la aplicación.
- Crear o lanzar el menú principal.
- Arrancar el flujo general del programa.

---

## 4. Flujo funcional resumido

Ejemplo de uso de la aplicación:

1. El usuario ejecuta `Main`.
2. `Main` lanza `MainMenu`.
3. El usuario accede, por ejemplo, a `ClienteMenu`.
4. `ClienteMenu` recoge los datos y crea un objeto `Cliente` cuando es necesario.
5. `ClienteMenu` llama a `ClienteService`.
6. `ClienteService` valida y delega en `ClienteDAO`.
7. `ClienteDAO` usa `DBConnection` para ejecutar la operación SQL.
8. El resultado vuelve en sentido inverso hasta mostrarse por consola.