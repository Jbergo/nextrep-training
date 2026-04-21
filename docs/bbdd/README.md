# Módulo de Bases de Datos

## Índice

1. [Descripción del módulo](#1-descripción-del-módulo)
2. [Contexto del proyecto](#2-contexto-del-proyecto)
3. [Objetivo de la base de datos](#3-objetivo-de-la-base-de-datos)
4. [Estructura de archivos del módulo](#4-estructura-de-archivos-del-módulo)
5. [Diagrama E/R](#5-diagrama-er)
6. [Modelo relacional](#6-modelo-relacional)
7. [Scripts SQL incluidos](#7-scripts-sql-incluidos)

   7.1. [`sql/schema.sql`](#71-sqlschemasql)

   7.2. [`sql/seed.sql`](#72-sqlseedsql)

   7.3. [`sql/queries.sql`](#73-sqlqueriessql)

8. [Consultas del proyecto](#8-consultas-del-proyecto)

9. [Relación con la web y con la app Java](#9-relación-con-la-web-y-con-la-app-java)

   9.1. [Relación con la web](#91-relación-con-la-web)

   9.2. [Relación con la base de datos](#92-relación-con-la-base-de-datos)
   
   9.3. [Relación con la app Java](#93-relación-con-la-app-java)

---

## 1. Descripción del módulo

Este directorio documenta el trabajo realizado para el módulo de **Bases de Datos (0484)** dentro del Proyecto Intermodular de 1.º DAW.

En este módulo se diseña y construye la base de datos de la empresa ficticia **NextRep Training**, asegurando que el modelo de datos sea coherente con el negocio, que las relaciones entre entidades estén bien definidas y que la implementación en SQL permita trabajar con datos reales del proyecto.

La finalidad de esta parte no es únicamente crear tablas, sino demostrar un proceso completo de análisis, modelado e implementación de una base de datos relacional adaptada a una necesidad concreta.

---

## 2. Contexto del proyecto

**NextRep Training** es una empresa ficticia de servicios de entrenamiento online. Su portal web está orientado a presentar la empresa, mostrar un catálogo de planes de entrenamiento y permitir que los usuarios soliciten la contratación de un servicio.

Desde el módulo de bases de datos, el proyecto modela la información que la empresa necesita gestionar internamente para funcionar, especialmente:

- **Clientes** interesados en los servicios.
- **Planes** de entrenamiento disponibles.
- **Solicitudes** realizadas por los clientes.
- Gestión interna de dichas solicitudes por parte de un **administrador**.

---

## 3. Objetivo de la base de datos

El objetivo de esta base de datos es representar de forma estructurada el funcionamiento interno de NextRep Training mediante un modelo relacional que permita:

- Almacenar información de clientes.
- Registrar los planes ofrecidos por la empresa.
- Guardar las solicitudes de contratación.
- Relacionar cada solicitud con un cliente y un plan.
- Gestionar el estado de cada solicitud.
- Realizar consultas útiles para la operativa del negocio.

---

## 4. Estructura de archivos del módulo

```text
docs/
└── bbdd/
    ├── README.md
    ├── analisis-datos.md
    └── modelo-relacional.md

diagrams/
├── modelo_ER.png
├── modelo_relacional.png
└── modelos.drawio

sql/
├── schema.sql
├── seed.sql
└── queries.sql
```

---

## 5. Diagrama E/R

El diagrama Entidad–Relación del proyecto representa visualmente las entidades, atributos, claves y relaciones descritas anteriormente.

En él se muestran:

- Entidades del sistema.
- Atributos principales.
- Claves primarias.
- Claves foráneas.
- Relaciones entre entidades.
- Cardinalidades.

Archivos asociados:

- `diagrams/modelo_ER.png`.
- Archivo fuente `diagrams/modelos.drawio`.

---

## 6. Modelo relacional

A partir del diagrama E/R se obtiene el siguiente modelo relacional general:

En él se muestran:
- Tablas.
- Campos.
- Tipos de datos.
- Claves primarias.
- Claves foráneas.
- Restricciones.

Archivos asociados:

- `diagrams/modelo_relacional.png` (archivo visual del modelo).
- `docs/bbdd/modelo_relacional.md` (explicación de los tipos de datos y restricciones del modelo).
- Archivo fuente `diagrams/modelos.drawio`.

---

## 7. Scripts SQL incluidos

### 7.1. `sql/schema.sql`
Script encargado de:
- Crear la base de datos.
- Crear las tablas.
- Definir claves primarias.
- Definir claves foráneas.
- Aplicar restricciones básicas.

### 7.2. `sql/seed.sql`
Script encargado de:
- Insertar datos de ejemplo.

### 7.3. `sql/queries.sql`
Script encargado de:
- Incluir consultas útiles y realistas.
- Comprobar que las relaciones funcionan.
- Mostrar información útil para la empresa.

---

## 8. Consultas del proyecto

Las consultas incluidas en este módulo están pensadas para responder a necesidades reales del negocio. Entre ellas se incluyen, como mínimo:

- Listar todos los planes activos.
- Buscar planes activos por nivel.
- Listar todos los clientes.
- Buscar cliente por email.
- Listar solicitudes con datos de cliente y plan
- Filtrar solicitudes por estado.
- Ver solicitudes de un cliente concreto.
- Contar solicitudes por estado.
- Contar cuántas veces se ha solicitado cada plan.
- Ingresos potenciales por plan.

---

## 9. Relación con la web y con la app Java

Esta base de datos está alineada con el resto del proyecto intermodular:

### 9.1. Relación con la web
La web corporativa muestra la parte visible de NextRep Training:
- Presentación de la empresa.
- Catálogo de servicios.
- Información de los planes.

### 9.2. Relación con la base de datos
La base de datos representa cómo funciona internamente el negocio:
- Clientes.
- Planes.
- Solicitudes.
- Gestión administrativa.

### 9.3. Relación con la app Java
La aplicación Java por consola usa esta base de datos mediante JDBC para realizar operaciones reales como:
- Listar planes.
- Crear clientes.
- Registrar solicitudes.
- Consultar solicitudes relacionadas con clientes y planes.
- Aplicar operaciones CRUD.

De este modo, la base de datos no es genérica ni aislada, sino que forma parte del sistema completo de NextRep Training.