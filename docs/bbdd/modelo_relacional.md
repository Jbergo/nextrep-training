# Explicación del modelo relacional

## Índice

1. [Tablas del sistema](#1-tablas-del-sistema)

   1.1. [Tabla `cliente`](#11-tabla-cliente)

   1.2. [Tabla `plan`](#12-tabla-plan)

   1.3. [Tabla `administrador`](#13-tabla-administrador)

   1.4. [Tabla `solicitud`](#14-tabla-solicitud)

2. [Relaciones entre tablas](#2-relaciones-entre-tablas)

3. [Restricciones principales del modelo](#3-restricciones-principales-del-modelo)

---

## 1. Tablas del sistema

El modelo relacional de NextRep Training se compone de cuatro tablas principales:

- `cliente`
- `plan`
- `solicitud`
- `administrador`

---

### 1.1. Tabla `cliente`

**Finalidad:**  
Almacena la información básica de los clientes que consultan o contratan los servicios de entrenamiento online.

**Clave primaria:**  
- `id_cliente`

**Campos propuestos:**
- `id_cliente` INT AUTO_INCREMENT PRIMARY KEY
- `nombre` VARCHAR(50) NOT NULL
- `apellidos` VARCHAR(100) NOT NULL
- `email` VARCHAR(100) NOT NULL UNIQUE
- `telefono` VARCHAR(20)
- `nivel` VARCHAR(30) NOT NULL
- `objetivo` VARCHAR(100) NOT NULL
- `fecha_alta` DATE NOT NULL

**Restricciones principales:**
- El identificador del cliente debe ser único.
- El correo electrónico no puede repetirse.
- Los campos `nombre`, `apellidos`, `email`, `nivel`, `objetivo` y `fecha_alta` son obligatorios.
- El campo `telefono` puede quedar opcional en el MVP.

### 1.2. Tabla `plan`

**Finalidad:**  
Recoge la información de los planes de entrenamiento que la empresa ofrece a sus clientes.

**Clave primaria:**  
- `id_plan`

**Campos propuestos:**
- `id_plan` INT AUTO_INCREMENT PRIMARY KEY
- `nombre` VARCHAR(80) NOT NULL
- `tipo` VARCHAR(100) NOT NULL
- `nivel_requerido` ENUM('Principiante', 'Intermedio', 'Avanzado') NOT NULL
- `objetivo` VARCHAR(100) NOT NULL
- `duracion_semanas` INT NOT NULL
- `frecuencia_sesiones` INT NOT NULL
- `duracion_sesion` INT NOT NULL
- `personalizacion` ENUM('Baja', 'Media', 'Alta') NOT NULL
- `descripcion` TEXT
- `para_quien` TEXT
- `precio` DECIMAL(8,2) NOT NULL
- `activo` BOOLEAN NOT NULL

**Restricciones principales:**
- El identificador del plan debe ser único.
- Los campos `nombre`, `tipo`, `nivel_requerido`, `objetivo`, `duracion_semanas`, `frecuencia_sesiones`, `duracion_sesion`, `personalizacion`, `precio` y `activo` son obligatorios.
- El `precio` debe almacenarse con formato decimal.
- La `duración` del plan en semanas debe ser mayor que 0.
- La `frecuencia` de sesiones por semana debe ser mayor que 0.
- La `duración` de cada sesión debe almacenarse en minutos y ser mayor que 0.
- El campo `activo` permite distinguir entre planes disponibles y planes desactivados.
- El campo `nivel_requerido` debe reflejar el nivel mínimo recomendado para contratar el plan (principiante, intermedio, avanzado).
- El campo `personalizacion` permite indicar si el servicio es bajo, medio, alto.
- El campo `para_quien` sirve para describir el perfil de cliente al que va dirigido el plan.
- Los campos `descripcion` y `para_quien` son opcionales.
- Conviene limitar algunos valores de negocio mediante `CHECK` o validación en aplicación, por ejemplo en `nivel_requerido` y `personalizacion`, ya que en tu catálogo los planes se diferencian precisamente por tipo, nivel, objetivo, duración, frecuencia, personalización y precio.
- Esta estructura también encaja con el MVP definido para NextRep Training, donde los planes forman parte de la base de datos principal del negocio y deben ser gestionables desde la app Java.

### 1.3. Tabla `administrador`

**Finalidad:**  
Almacena la información del perfil interno que gestiona las solicitudes realizadas por los clientes.

**Clave primaria:**  
- `id_admin`

**Campos propuestos:**
- `id_admin` INT AUTO_INCREMENT PRIMARY KEY
- `nombre` VARCHAR(50) NOT NULL
- `apellidos` VARCHAR(100) NOT NULL
- `email` VARCHAR(100) NOT NULL UNIQUE

**Restricciones principales:**
- El identificador del administrador debe ser único.
- El correo electrónico no puede repetirse.
- Los campos `nombre`, `apellidos` y `email` son obligatorios.

### 1.4. Tabla `solicitud`

**Finalidad:**  
Registra las solicitudes de contratación realizadas por los clientes sobre los distintos planes ofrecidos por la empresa.

**Clave primaria:**  
- `id_solicitud`

**Claves foráneas:**  
- `id_cliente` → referencia a `clientes(id_cliente)`
- `id_plan` → referencia a `planes(id_plan)`
- `id_admin` → referencia a `administradores(id_admin)`

**Campos propuestos:**
- `id_solicitud` INT AUTO_INCREMENT PRIMARY KEY
- `id_cliente` INT NOT NULL
- `id_plan` INT NOT NULL
- `id_admin` INT
- `fecha_solicitud` DATE NOT NULL
- `estado` ENUM('Pendiente', 'Aprobada', 'Cancelada') NOT NULL
- `comentarios_cliente` TEXT
- `notas_internas` TEXT

**Restricciones principales:**
- Cada solicitud debe estar asociada a un cliente existente.
- Cada solicitud debe estar asociada a un plan existente.
- El campo `id_admin` puede quedar nulo en una primera fase si la solicitud aún no ha sido revisada.
- El campo `estado` es obligatorio para indicar la situación de la solicitud (pendiente, aprobada o cancelada). Por defecto es pendiente.
- Los campos `comentarios_cliente` y `notas_internas` son opcionales.

---

## 2. Relaciones entre tablas

A partir del diagrama E/R y del funcionamiento del negocio, las relaciones del modelo relacional quedan definidas de la siguiente manera:

- Un **cliente** puede realizar **varias solicitudes**, pero cada **solicitud** pertenece a **un único cliente**.
- Un **plan** puede aparecer en **varias solicitudes**, pero cada **solicitud** hace referencia a **un único plan**.
- Un **administrador** puede gestionar **varias solicitudes**, pero cada **solicitud** es gestionada por **un único administrador**.

Esto se implementa mediante FK en la tabla `solicitudes`, ya que es la tabla que se encuentra en el lado N de las relaciones.

---

## 3. Restricciones principales del modelo

Las restricciones más relevantes del modelo relacional son las siguientes:

- Todas las tablas tienen una **clave primaria** que identifica de forma única cada registro.
- Las relaciones entre tablas se implementan con **claves foráneas** para mantener la integridad referencial.
- El campo `email` es **UNIQUE** en las tablas `clientes` y `administradores`.
- Los campos esenciales del negocio están definidos como **NOT NULL**.
- Los campos de texto largo, como comentarios o descripciones, se almacenan como **TEXT**.
- El campo `activo` en `planes` permite gestionar la disponibilidad de los servicios sin necesidad de eliminar registros.
- El campo `estado` en `solicitudes` permitirá clasificar solicitudes, por ejemplo: `pendiente`, `aceptada`, `rechazada` o `completada`.