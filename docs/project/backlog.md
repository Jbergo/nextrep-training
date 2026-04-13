# Backlog maestro — NextRep Training

> Proyecto Intermodular 1º DAW  

---

# Épica 0 — Planificación operativa

## Objetivo
Dejar definido el marco de trabajo del proyecto antes de desarrollar.

## Tareas
- [ ] Confirmar nombre definitivo del proyecto: NextRep Training
- [ ] Confirmar propuesta de valor de la empresa ficticia
- [ ] Confirmar alcance MVP realista
- [ ] Confirmar módulos que cubre el proyecto
- [ ] Definir orden general de implementación
- [ ] Crear roadmap general por fases
- [ ] Crear checklist general de entregables
- [ ] Crear documento `docs/project-overview.md`
- [ ] Crear documento `docs/project-backlog.md`
- [ ] Revisar que web, BBDD y Java estén alineados conceptualmente

## Entregables
- [ ] `docs/project-overview.md`
- [ ] `docs/project-backlog.md`

---

# Épica 1 — Kickoff y definición funcional

## Objetivo
Cerrar qué es NextRep Training, qué problema resuelve y qué entra en el MVP.

## Tareas
- [ ] Redactar descripción corta del negocio
- [ ] Redactar descripción extendida del proyecto
- [ ] Definir público objetivo final
- [ ] Definir problema que resuelve
- [ ] Definir propuesta de valor
- [ ] Definir catálogo inicial de servicios
- [ ] Definir qué datos necesita un cliente para contratar
- [ ] Definir qué datos gestiona internamente la empresa
- [ ] Definir funcionalidades mínimas de la web
- [ ] Definir funcionalidades mínimas de la BBDD
- [ ] Definir funcionalidades mínimas de la app Java
- [ ] Definir qué queda fuera del MVP
- [ ] Redactar criterios de aceptación del proyecto

## Entregables
- [ ] `docs/project-overview.md`

---

# Épica 2 — Repositorio y workflow profesional

## Objetivo
Crear la base del proyecto con estructura profesional y control de versiones correcto.

## Tareas
- [ ] Crear repositorio GitHub `nextrep-training`
- [ ] Crear rama principal `main`
- [ ] Añadir archivo `.gitignore` para Java e IntelliJ
- [ ] Crear carpeta `web/`
- [ ] Crear carpeta `sql/`
- [ ] Crear carpeta `docs/`
- [ ] Crear carpeta `diagrams/`
- [ ] Crear carpeta `assets/`
- [ ] Crear estructura interna inicial de `docs/`
- [ ] Crear `README.md` inicial
- [ ] Añadir descripción inicial del proyecto al README
- [ ] Añadir tecnologías al README
- [ ] Añadir estructura del repositorio al README
- [ ] Definir convención de commits
- [ ] Crear documento `docs/workflow.md`
- [ ] Hacer primer commit con la estructura base
- [ ] Subir repositorio a GitHub
- [ ] Verificar que el repositorio queda limpio y sin archivos basura

## Entregables
- [ ] `README.md`
- [ ] `.gitignore`
- [ ] `docs/workflow.md`

---

# Épica 3 — Análisis de datos del negocio

## Objetivo
Identificar correctamente las entidades y relaciones del negocio.

## Tareas
- [ ] Describir procesos del negocio
- [ ] Analizar qué información maneja la empresa
- [ ] Identificar entidades candidatas
- [ ] Seleccionar entidades definitivas del MVP
- [ ] Definir atributos de cada entidad
- [ ] Definir claves primarias
- [ ] Detectar relaciones entre entidades
- [ ] Definir cardinalidades
- [ ] Revisar si hacen falta entidades de apoyo
- [ ] Redactar análisis de datos
- [ ] Revisar coherencia entre negocio, web y BBDD

## Entidades MVP recomendadas
- [ ] Cliente
- [ ] Plan
- [ ] Solicitud
- [ ] Administrador

## Entregables
- [ ] `docs/bbdd/analisis-datos.md`

---

# Épica 4 — Diseño E/R y modelo relacional

## Objetivo
Diseñar la estructura completa de la base de datos antes de programar fuerte.

## Tareas
- [ ] Crear primer borrador del diagrama E/R
- [ ] Añadir entidades al diagrama
- [ ] Añadir atributos
- [ ] Añadir claves primarias
- [ ] Añadir relaciones
- [ ] Añadir cardinalidades
- [ ] Revisar redundancias
- [ ] Validar coherencia del modelo
- [ ] Generar versión final del diagrama E/R
- [ ] Crear modelo relacional a partir del E/R
- [ ] Definir tablas
- [ ] Definir campos
- [ ] Definir tipos de datos
- [ ] Definir claves foráneas
- [ ] Definir restricciones

## Entregables
- [ ] `diagrams/er-diagram.png`
- [ ] `docs/bbdd/modelo-relacional.md`

---

# Épica 5 — Scripts SQL

## Objetivo
Tener la BBDD lista para crear, poblar y consultar desde cero.

## Tareas
- [ ] Crear archivo `sql/schema.sql`
- [ ] Crear base de datos `nextrep_training`
- [ ] Crear tabla `clientes`
- [ ] Crear tabla `planes`
- [ ] Crear tabla `solicitudes`
- [ ] Crear tabla `administradores`
- [ ] Definir claves foráneas
- [ ] Probar creación completa sin errores
- [ ] Crear archivo `sql/seed.sql`
- [ ] Insertar planes de ejemplo
- [ ] Insertar clientes de ejemplo
- [ ] Insertar solicitudes de ejemplo
- [ ] Insertar administrador de ejemplo
- [ ] Crear archivo `sql/queries.sql`
- [ ] Añadir consulta para listar planes activos
- [ ] Añadir consulta para listar clientes
- [ ] Añadir consulta para listar solicitudes con JOIN
- [ ] Añadir consulta para filtrar por estado
- [ ] Añadir consulta para filtrar por nivel
- [ ] Añadir consulta de resumen o estadística simple
- [ ] Verificar ejecución completa de todos los scripts desde cero

## Entregables
- [ ] `sql/schema.sql`
- [ ] `sql/seed.sql`
- [ ] `sql/queries.sql`

---

# Épica 6 — Diseño técnico de la aplicación Java

## Objetivo
Definir una arquitectura clara y mantenible antes de implementar.

## Tareas
- [ ] Crear proyecto Java en IntelliJ
- [ ] Definir paquete base
- [ ] Crear capa `config`
- [ ] Crear capa `model`
- [ ] Crear capa `dao`
- [ ] Crear capa `service`
- [ ] Crear capa `ui`
- [ ] Crear clase `Main`
- [ ] Diseñar menú principal
- [ ] Definir casos de uso MVP
- [ ] Diseñar clases modelo
- [ ] Definir responsabilidades por capa
- [ ] Diseñar flujo de interacción por consola
- [ ] Redactar documento de arquitectura
- [ ] Revisar alineación con la BBDD

## Entregables
- [ ] `docs/programming/arquitectura.md`

---

# Épica 7 — Configuración JDBC y conexión real

## Objetivo
Conectar la aplicación Java con MariaDB mediante JDBC.

## Tareas
- [ ] Instalar o verificar MariaDB
- [ ] Crear la BBDD local
- [ ] Descargar o añadir driver JDBC
- [ ] Configurar IntelliJ para usar el driver
- [ ] Crear clase de conexión
- [ ] Configurar URL de conexión
- [ ] Configurar usuario y contraseña
- [ ] Probar conexión real desde Java
- [ ] Mostrar mensaje de conexión correcta
- [ ] Gestionar errores de conexión
- [ ] Documentar configuración JDBC

## Entregables
- [ ] `src/.../config/DatabaseConnection.java`
- [ ] `docs/programming/jdbc-setup.md`

---

# Épica 8 — Implementación Java end-to-end por entidad

## Objetivo
Desarrollar la app por bloques pequeños y comprobables.

## Bloque 8.1 — Gestión de planes
- [ ] Crear clase `Plan`
- [ ] Crear `PlanDAO`
- [ ] Implementar `findAll()`
- [ ] Implementar `findById()`
- [ ] Implementar filtro por nivel o activos
- [ ] Crear `PlanService`
- [ ] Añadir opción de menú para listar planes
- [ ] Probar lectura real desde BBDD

## Bloque 8.2 — Gestión de clientes
- [ ] Crear clase `Cliente`
- [ ] Crear `ClienteDAO`
- [ ] Implementar `save()`
- [ ] Implementar `findAll()`
- [ ] Implementar `update()`
- [ ] Implementar `deleteById()`
- [ ] Crear `ClienteService`
- [ ] Crear menú de gestión de clientes
- [ ] Validar datos básicos
- [ ] Probar CRUD completo de clientes

## Bloque 8.3 — Gestión de solicitudes
- [ ] Crear clase `Solicitud`
- [ ] Crear `SolicitudDAO`
- [ ] Implementar `save()`
- [ ] Implementar `findAll()`
- [ ] Implementar `findByEstado()`
- [ ] Implementar `updateEstado()`
- [ ] Implementar `deleteById()`
- [ ] Crear `SolicitudService`
- [ ] Crear menú de gestión de solicitudes
- [ ] Mostrar listados con JOIN cliente + plan
- [ ] Probar CRUD completo de solicitudes

## Entregables
- [ ] Código fuente Java funcional
- [ ] Menú de consola operativo
- [ ] CRUD real con JDBC

---

# Épica 9 — Validaciones, errores y reglas de negocio

## Objetivo
Aumentar la calidad de la app y evitar errores de uso o de datos.

## Tareas
- [ ] Validar campos obligatorios
- [ ] Validar email
- [ ] Validar teléfono
- [ ] Validar niveles permitidos
- [ ] Validar objetivos permitidos
- [ ] Validar estados de solicitud
- [ ] Evitar inserciones incompletas
- [ ] Capturar excepciones SQL
- [ ] Capturar errores de entrada por consola
- [ ] Mostrar mensajes claros de error
- [ ] Crear utilidades de lectura segura
- [ ] Evitar duplicidad de validaciones
- [ ] Aplicar reglas de negocio básicas

## Reglas de negocio mínimas
- [ ] No permitir solicitud sin cliente existente
- [ ] No permitir solicitud sin plan existente
- [ ] No permitir estado inválido
- [ ] No permitir email duplicado si se define `UNIQUE`

## Entregables
- [ ] Módulo de validaciones funcional
- [ ] Mejor manejo de errores en consola

---

# Épica 10 — Web corporativa HTML/CSS/JS

## Objetivo
Construir la parte visible del proyecto con una imagen profesional y coherente.

## Tareas
- [ ] Crear `web/index.html`
- [ ] Crear `web/servicios.html`
- [ ] Crear `web/sobre-nosotros.html`
- [ ] Crear `web/contacto.html`
- [ ] Crear cabecera común
- [ ] Crear menú de navegación funcional
- [ ] Crear pie de página común
- [ ] Crear hoja de estilos principal
- [ ] Definir paleta de colores
- [ ] Definir tipografías
- [ ] Maquetar Home
- [ ] Maquetar página de servicios
- [ ] Maquetar página sobre nosotros
- [ ] Maquetar página de contacto
- [ ] Añadir tarjetas de planes
- [ ] Añadir formulario de contacto
- [ ] Añadir JavaScript básico
- [ ] Añadir responsive básico
- [ ] Añadir imágenes y recursos visuales
- [ ] Revisar HTML semántico
- [ ] Comprobar navegación entre páginas
- [ ] Verificar visualización en móvil y escritorio

## Entregables
- [ ] `web/index.html`
- [ ] `web/servicios.html`
- [ ] `web/sobre-nosotros.html`
- [ ] `web/contacto.html`
- [ ] `web/css/styles.css`
- [ ] `web/js/main.js`

---

# Épica 11 — README y documentación general

## Objetivo
Hacer que el proyecto sea entendible y reproducible por cualquier persona.

## Tareas
- [ ] Completar `README.md`
- [ ] Añadir resumen del proyecto
- [ ] Añadir problema que resuelve
- [ ] Añadir tecnologías
- [ ] Añadir estructura del repositorio
- [ ] Añadir instrucciones para abrir la web
- [ ] Añadir instrucciones para crear la BBDD
- [ ] Añadir instrucciones para ejecutar la app Java
- [ ] Añadir funcionalidades principales
- [ ] Añadir sección de arquitectura Java
- [ ] Añadir sección de scripts SQL
- [ ] Añadir sección de mejora MPO
- [ ] Añadir capturas o ejemplos si procede
- [ ] Revisar claridad y orden del README

## Entregables
- [ ] `README.md` final

---

# Épica 12 — MPO: mejora estructural visible

## Objetivo
Aplicar una mejora clara respecto al proyecto base y documentarla.

## Tareas
- [ ] Revisar responsabilidades en `Main`
- [ ] Separar mejor UI, lógica y acceso a datos
- [ ] Refactorizar código duplicado
- [ ] Mejorar nombres de clases y métodos
- [ ] Crear utilidades reutilizables
- [ ] Centralizar validaciones
- [ ] Mejorar flujo de menús
- [ ] Definir reglas de negocio más claras
- [ ] Crear mini diagrama de clases
- [ ] Documentar qué parte corresponde al MPO
- [ ] Redactar documento de mejora estructural

## Entregables
- [ ] `docs/mpo/mejora-estructural.md`
- [ ] `docs/mpo/diagrama-clases.png`

---

# Épica 13 — Sistemas Informáticos

## Objetivo
Documentar el entorno real de ejecución del proyecto.

## Tareas
- [ ] Definir tipo de sistema donde se ejecuta
- [ ] Justificar la elección del entorno
- [ ] Definir requisitos mínimos de hardware
- [ ] Definir requisitos recomendados de hardware
- [ ] Elegir sistema operativo recomendado
- [ ] Justificar el sistema operativo elegido
- [ ] Documentar instalación de Java
- [ ] Documentar instalación de IntelliJ
- [ ] Documentar instalación de MariaDB
- [ ] Documentar creación de la base de datos
- [ ] Documentar ejecución de la app Java
- [ ] Documentar apertura de la web
- [ ] Definir usuarios y permisos básicos
- [ ] Definir estructura de carpetas y datos
- [ ] Definir copias de seguridad básicas
- [ ] Definir mantenimiento básico
- [ ] Añadir evidencias con capturas
- [ ] Revisar que la guía sea replicable

## Entregables
- [ ] `docs/sistemas/informe-tecnico.md`
- [ ] Capturas de funcionamiento

---

# Épica 14 — Empleabilidad

## Objetivo
Presentar el proyecto como portfolio profesional inicial.

## Tareas
- [ ] Redactar perfil profesional breve
- [ ] Redactar presentación profesional del proyecto
- [ ] Crear portfolio básico
- [ ] Añadir capturas del proyecto
- [ ] Añadir enlace al repositorio
- [ ] Explicar tecnologías utilizadas
- [ ] Explicar qué has aprendido
- [ ] Redactar reflexión final
- [ ] Revisar bio de GitHub
- [ ] Ordenar carpeta de empleabilidad

## Entregables
- [ ] `docs/empleabilidad/perfil-profesional.md`
- [ ] `docs/empleabilidad/presentacion-proyecto.md`
- [ ] `docs/empleabilidad/portfolio.md`
- [ ] `docs/empleabilidad/reflexion-final.md`

---

# Épica 15 — Auditoría final y entrega

## Objetivo
Cerrar el proyecto con calidad profesional y comprobar que todo se puede reproducir.

## Tareas
- [ ] Revisar estructura final del repositorio
- [ ] Revisar nombres de carpetas y archivos
- [ ] Revisar `.gitignore`
- [ ] Revisar `README.md`
- [ ] Probar `schema.sql` desde cero
- [ ] Probar `seed.sql` desde cero
- [ ] Probar `queries.sql`
- [ ] Verificar que la app Java compila
- [ ] Verificar que JDBC conecta correctamente
- [ ] Verificar CRUD completo
- [ ] Verificar consultas útiles
- [ ] Revisar la web en escritorio
- [ ] Revisar la web en móvil
- [ ] Revisar documentación de sistemas
- [ ] Revisar documentación de empleabilidad
- [ ] Revisar documentación MPO
- [ ] Revisar capturas y evidencias
- [ ] Eliminar archivos innecesarios
- [ ] Verificar reproducibilidad completa desde cero
- [ ] Crear checklist final de entrega
- [ ] Preparar release o tag final opcional

## Entregables
- [ ] Repositorio listo para entrega
- [ ] Checklist final completado

---

# Prioridad recomendada

## Prioridad alta
- [ ] Épica 0 — Planificación operativa
- [ ] Épica 1 — Kickoff y definición funcional
- [ ] Épica 2 — Repositorio y workflow profesional
- [ ] Épica 3 — Análisis de datos
- [ ] Épica 4 — Diseño E/R y modelo relacional
- [ ] Épica 5 — Scripts SQL
- [ ] Épica 6 — Diseño técnico Java
- [ ] Épica 7 — Configuración JDBC

## Prioridad media
- [ ] Épica 8 — Implementación Java
- [ ] Épica 9 — Validaciones y reglas de negocio
- [ ] Épica 10 — Web corporativa

## Prioridad media-baja
- [ ] Épica 11 — README y documentación general
- [ ] Épica 12 — MPO
- [ ] Épica 13 — Sistemas Informáticos
- [ ] Épica 14 — Empleabilidad

## Prioridad final
- [ ] Épica 15 — Auditoría final y entrega

---

# Vista rápida de avance

## Fase 1
- [ ] Planificación operativa
- [ ] Kickoff y definición funcional
- [ ] Repo y workflow

## Fase 2
- [ ] Análisis de datos
- [ ] E/R y modelo relacional
- [ ] SQL

## Fase 3
- [ ] Diseño técnico Java
- [ ] JDBC
- [ ] Implementación Java
- [ ] Validaciones

## Fase 4
- [ ] Web corporativa

## Fase 5
- [ ] MPO
- [ ] Sistemas
- [ ] Empleabilidad

## Fase 6
- [ ] Auditoría final y entrega
