# Análisis de datos

# Índice

1. [Tipo de empresa](#1-tipo-de-empresa)
2. [Qué información maneja el negocio](#2-qué-información-maneja-el-negocio)

   2.1. [Acerca de los clientes](#21-acerca-de-los-clientes)

   2.2. [Acerca del catálogo de planes](#22-acerca-del-catálogo-de-planes)
   
   2.3. [Acerca de las solicitudes de contratación](#23-acerca-de-las-solicitudes-de-contratación)

   2.4. [Acerca de gestión interna](#24-acerca-de-gestión-interna)

3. [Entidades identificadas](#3-entidades-identificadas)

   3.1. [Cliente](#31-cliente)

   3.2. [Plan](#32-plan)

   3.3. [Solicitud](#33-solicitud)

   3.4. [Administrador](#34-administrador)

4. [Relaciones entre entidades](#4-relaciones-entre-entidades)

   4.1. [Cliente — Solicitud](#41-cliente--solicitud)

   4.2. [Plan — Solicitud](#42-plan--solicitud)
   
   4.3. [Administrador — Solicitud](#43-administrador--solicitud)

## 1. Tipo de empresa

---

## 1. Tipo de empresa

**NextRep Training**, como se menciona anteriormente, representa una **empresa de servicios deportivos online** especializada en la comercialización de planes de entrenamiento adaptados a distintos niveles y objetivos. No se trata de una tienda de productos físicos, sino de un negocio digital centrado en la oferta de servicios de entrenamiento estructurados.

La empresa utiliza su web corporativa para:
- Presentar su propuesta de valor.
- Mostrar el catálogo de planes.
- Explicar cada servicio.
- Permitir que un cliente solicite la contratación de un plan.

Desde el punto de vista interno, la empresa necesita registrar clientes, planes, solicitudes y una persona que administre dichas solicitudes. Esa necesidad es la que da sentido al diseño de la base de datos.

---

## 2. Qué información maneja el negocio

A partir de la definición del proyecto, del MVP y del catálogo inicial de servicios, puede concluirse que NextRep Training gestiona principalmente cuatro bloques de información:

### 2.1. Acerca de los clientes
La empresa necesita almacenar datos básicos de los usuarios interesados en contratar un servicio, como nombre, apellidos, email, teléfono, nivel, objetivo y fecha de alta. Estos datos permiten identificar al cliente y relacionarlo con futuras solicitudes.

### 2.2. Acerca del catálogo de planes
La empresa ofrece distintos planes de entrenamiento online con características diferenciadas por nivel, objetivo, duración y precio. En la documentación del proyecto ya están definidos ejemplos claros como **Plan Start**, **Plan Fat Loss**, **Plan Hypertrophy** y **Plan Cross Training**, cada uno con nivel, duración y precio específicos.

### 2.3. Acerca de las solicitudes de contratación
La operación principal del negocio es que un cliente solicite un plan concreto. Por ello, la base de datos debe registrar qué cliente solicita qué plan, en qué fecha, en qué estado se encuentra la solicitud y qué comentarios o notas están asociados al proceso. Esta necesidad está recogida expresamente en el MVP.

### 2.4. Acerca de gestión interna
Aunque el proyecto tiene un alcance MVP, también se contempla una gestión interna mínima. Para ello se incorpora la figura de **administrador**, que permite asociar solicitudes a la persona responsable de revisarlas o gestionarlas.

---

## 3. Entidades identificadas

De acuerdo con el análisis del negocio y con las entidades MVP, el sistema se ha estructurado alrededor de estas cuatro entidades principales: **Cliente**, **Plan**, **Solicitud** y **Administrador**.

### 3.1. Cliente
Representa a la persona interesada en contratar un plan de entrenamiento.

**Información principal:**
- ID cliente
- Nombre
- Apellidos
- Email
- Teléfono
- Nivel
- Objetivo
- Fecha alta

### 3.2. Plan
Representa cada servicio de entrenamiento ofrecido por la empresa.

**Información principal:**
- ID plan
- Nombre
- Tipo
- Nivel requerido
- Objetivo
- Duración (semanas)
- Frecuencia (sesiones/semana)
- Duración (sesión)
- Personalización
- Descripción
- Para quien
- Precio
- Activo

### 3.3. Solicitud
Representa una petición de contratación realizada por un cliente sobre un plan concreto.

**Información principal:**
- ID solicitud
- ID cliente
- ID plan
- ID admin
- Fecha solicitud
- Estado
- Comentarios cliente
- Notas internas

### 3.4. Administrador
Representa al personal interno que revisa y gestiona las solicitudes.

**Información principal:**
- ID admin
- Nombre
- Apellidos
- Email

---

## 4. Relaciones entre entidades
Una vez identificadas las entidades, el siguiente paso del análisis de datos es determinar cómo se relacionan entre sí. De forma que estas relaciones convierten a **Solicitud** en la entidad central del negocio, ya que actúa como punto de unión entre la parte comercial y la parte de gestión interna.:

### 4.1. Cliente — Solicitud
Un **cliente** puede realizar varias solicitudes, pero cada **solicitud** pertenece a un único cliente.

**Cardinalidad:** `1 : N`

### 4.2. Plan — Solicitud
Un **plan** se puede corresponder a varias solicitudes, pero cada **solicitud** hace referencia a un único plan.

**Cardinalidad:** `1 : N`

### 4.3. Administrador — Solicitud
Un **administrador** puede gestionar múltiples solicitudes, mientras que cada **solicitud** queda asociada a un único administrador.

**Cardinalidad:** `1 : N`