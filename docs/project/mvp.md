# Descripción del proyecto

NextRep Training es una aplicación web orientada a la venta de servicios de entrenamiento online. Su objetivo es permitir a los usuarios consultar distintos planes de entrenamiento según su nivel y objetivo, solicitar su contratación y gestionar estas solicitudes mediante una base de datos relacional y una aplicación desarrollada en Java con JDBC.

---

# Datos 

## Necesarios del Cliente
- Nombre
- Apellidos
- Email
- Teléfono
- Servicio a contratar
- Experiencia
- Objetivo
- Comentarios

## Gestionados por la Empresa

### Cliente

- ID cliente
- Nombre
- Apellidos
- Email
- Teléfono
- Experiencia
- Objetivo
- Fecha alta

### Plan

- ID plan
- Nombre
- Descripción
- Precio
- Duración
- Nivel
- Activo

### Solicitud

- ID solicitud
- ID cliente
- ID plan
- Fecha solicitud
- Estado
- Comentarios cliente
- Notas internas

---

# MVP

El MVP de NextRep Training consistirá en una web corporativa informativa con catálogo de planes, una base de datos relacional con clientes, planes, solicitudes y administradores, y una aplicación Java por consola conectada por JDBC que permita realizar CRUD reales y consultas útiles sobre esa información.

## Funcionalidades mínimas

### Web corporativa
- Mostrar la identidad de la empresa NextRep Training.
- Presentar el catálogo inicial de planes de entrenamiento.
- Incluir páginas de Home, Servicios, Sobre Nosotros y Contacto.
- Permitir navegación funcional entre páginas.
- Tener diseño responsive básico.
- Incluir JavaScript básico para interacción simple o validación de formulario.

### Base de datos
- Gestionar la información principal del negocio mediante tablas de clientes, planes, solicitudes y administradores.
- Permitir registrar qué cliente solicita qué plan.
- Incluir scripts SQL de creación, inserción de datos de ejemplo y consultas.
- Incorporar consultas útiles para el negocio, incluyendo al menos un JOIN.

### Aplicación Java por consola
- Conectarse a la base de datos mediante JDBC.
- Mostrar un menú principal usable por consola.
- Permitir listar planes disponibles.
- Permitir realizar CRUD de clientes.
- Permitir realizar CRUD de solicitudes.
- Permitir consultar solicitudes con datos relacionados de cliente y plan.
- Gestionar errores básicos de entrada y de base de datos.

### Límites del MVP
Quedan fuera del alcance mínimo funcionalidades como pagos reales, login completo, integración web-BBDD en tiempo real, panel administrativo web y módulos avanzados no necesarios.

---

# Criterios de aceptación del proyecto

1. La idea de negocio esté definida y sea coherente en web, base de datos y aplicación Java.
2. La web corporativa incluya como mínimo Home, Servicios, Sobre nosotros y Contacto.
3. La navegación entre páginas funcione correctamente.
4. La web tenga estructura HTML semántica, CSS ordenado y responsive básico.
5. El catálogo de servicios muestre planes reales y entendibles para el usuario.
6. Exista una base de datos relacional alineada con el negocio.
7. La base de datos incluya como mínimo las entidades clientes, planes, solicitudes y administradores.
8. El proyecto incluya scripts `schema.sql`, `seed.sql` y `queries.sql` ejecutables sin errores.
9. La aplicación Java se conecte realmente a la base de datos mediante JDBC.
10. La aplicación permita listar planes y realizar CRUD de clientes y solicitudes.
11. La aplicación muestre consultas útiles del negocio, incluyendo al menos un JOIN.
12. Exista un menú por consola usable para interactuar con la aplicación.
13. El programa gestione errores básicos y valide datos mínimos.
14. El código esté organizado de forma clara y mantenible.
15. El repositorio GitHub tenga estructura profesional, commits descriptivos y README completo.
16. Una persona externa pueda clonar el repositorio y reproducir la ejecución siguiendo la documentación.