# Módulo de Programación

## 1. Descripción del módulo

Este módulo corresponde a la parte de **Programación** del Proyecto Intermodular de **NextRep Training**, una empresa ficticia dedicada a la venta de servicios de entrenamiento online.

La aplicación desarrollada para este módulo es una **app Java por consola** conectada a una base de datos relacional mediante **JDBC**, cuya finalidad es gestionar información real del negocio, especialmente clientes, planes, solicitudes y datos administrativos básicos.

La app forma parte del proyecto global junto con:

- Una web corporativa en HTML, CSS y JavaScript.
- Una base de datos en MySQL.
- Documentación técnica y funcional en el repositorio.

---

## 2. Objetivo del módulo

El objetivo principal de este módulo es demostrar:

- Uso correcto de fundamentos de programación en Java.
- Organización del código en clases y paquetes.
- Conexión real con base de datos mediante JDBC.
- Implementación de operaciones CRUD.
- Menús funcionales por consola.
- Coherencia con la empresa ficticia y con el diseño de la base de datos.

---

## 3. Qué hace la aplicación

La app Java permite gestionar la información principal de NextRep Training mediante menús de consola.

Funcionalidades principales:

- Listar planes de entrenamiento.
- Filtrar planes por nivel.
- Listar clientes.
- Buscar clientes por email.
- Dar de alta nuevos clientes.
- Modificar datos de clientes.
- Eliminar clientes.
- Listar solicitudes.
- Buscar solicitudes por estado.
- Crear nuevas solicitudes.
- Modificar solicitudes.
- Eliminar solicitudes.
- Consultar información administrativa básica.

---

## 4. Entidades gestionadas

La aplicación trabaja con las siguientes entidades:

### Cliente
Representa al usuario que solicita o contrata un plan.

Campos principales:

- idCliente
- nombre
- apellidos
- email
- telefono
- nivel
- objetivo
- fechaAlta

### Plan
Representa un servicio o programación de entrenamiento.

Campos principales:

- idPlan
- nombre
- tipo
- nivelRequerido
- objetivo
- duracionSemanas
- frecuenciaSesiones
- duracionSesion
- personalizacion
- descripcion
- paraQuien
- precio
- activo

### Solicitud
Representa la solicitud de contratación de un plan.

Campos principales:

- idSolicitud
- idCliente
- idPlan
- idAdmin
- fechaSolicitud
- estado
- comentariosCliente
- notasInternas

### Administrador
Representa al usuario interno que gestiona la información administrativa.

Campos principales:

- idAdmin
- nombre
- apellidos
- email

---

## 5. Arquitectura de la aplicación

Para ver información sobre la arquitectura, existe un archivo llamado `docs/programming/arquitectura.md`.

### Resumen de responsabilidades

- `config`: conexión JDBC.
- `model`: clases del dominio y enums.
- `dao`: acceso a base de datos.
- `service`: lógica de negocio y validaciones.
- `ui`: menús y flujo de consola.
- `Main`: punto de entrada.

---

## 6. Ejecución de la aplicación

### Desde IntelliJ

1. Abrir el proyecto Java.
2. Asegurarse de que el driver JDBC está añadido al proyecto.
3. Revisar `DBConnection.java`.
4. Ejecutar la clase `Main`.
5. Navegar por el menú principal de la consola.

### Flujo general

- `Main` inicia la aplicación.
- `MainMenu` muestra las opciones disponibles.
- Cada submenú permite operar sobre una entidad concreta.
- La capa `service` coordina la lógica.
- La capa `dao` realiza las operaciones SQL reales.

---

## 7. Operaciones principales del módulo

### Gestión de clientes

- Alta de clientes.
- Listado de clientes.
- Búsqueda por email.
- Modificación de datos.
- Eliminación de registros.

### Gestión de planes

- Listado de planes.
- Filtro por nivel.
- Consulta de planes activos.

### Gestión de solicitudes

- Alta de solicitudes.
- Listado de solicitudes.
- Filtrado por estado.
- Modificación de solicitudes.
- Eliminación de solicitudes.

### Gestión administrativa básica

- Consulta de información del administrador.
- Listado de administradores si se mantiene esta opción.

## 8. Uso de JDBC en el proyecto

La conexión JDBC es una parte obligatoria del módulo.

En esta aplicación JDBC se utiliza para:

- Conectar con la base de datos real.
- Ejecutar operaciones CRUD.
- Realizar consultas útiles del negocio.
- Recuperar resultados desde SQL.
- Mostrar información real por consola.

## 9. Relación con la base de datos

La aplicación está alineada con la base de datos diseñada en el módulo de BBDD.

Relación conceptual:

- La web presenta la empresa.
- La base de datos modela el negocio.
- La app Java opera sobre ese modelo con JDBC.