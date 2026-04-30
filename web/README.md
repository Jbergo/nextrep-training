# Módulo de Lenguaje de Marcas

# Índice

1. [NextRep Training](#nextrep-training)
2. [Objetivo de la web](#objetivo-de-la-web)
3. [Páginas incluidas](#páginas-incluidas)
4. [Catálogo de servicios](#catálogo-de-servicios)
5. [Tecnologías utilizadas](#tecnologías-utilizadas)
6. [Estructura recomendada de la carpeta web](#estructura-recomendada-de-la-carpeta-web)
7. [Cómo abrir la web](#cómo-abrir-la-web)
   - [Opción 1 — Abrir directamente](#opción-1--abrir-directamente)
   - [Opción 2 — Usar Live Server si se trabaja con VS Code](#opción-2--usar-live-server-si-se-trabaja-con-vs-code)
8. [Relación con el resto del proyecto](#relación-con-el-resto-del-proyecto)

---

## NextRep Training

**NextRep Training** es la parte web corporativa del Proyecto Intermodular de 1.º DAW. Representa una empresa ficticia dedicada a ofrecer servicios de entrenamiento online mediante planes organizados por nivel, objetivo y duración.

Esta web funciona como carta de presentación de la empresa y como escaparate de sus servicios. Su finalidad es que una persona usuaria pueda conocer la marca, consultar los planes disponibles y acceder a una página de contacto para solicitar más información.

---

## Objetivo de la web

La web tiene como objetivo presentar de forma clara y profesional la empresa **NextRep Training**, dedicada a la venta de servicios de entrenamiento online.

La propuesta está orientada a usuarios que quieren mejorar su condición física con planes estructurados, sin depender de un centro deportivo presencial.

La web permite:

- Presentar la identidad de la empresa.
- Explicar qué ofrece NextRep Training.
- Mostrar un catálogo de planes de entrenamiento online.
- Informar sobre la filosofía de trabajo de la empresa.
- Facilitar una vía de contacto mediante formulario.
- Mantener coherencia visual con el resto del proyecto: base de datos, aplicación Java y documentación.

---

## Páginas incluidas

La app web está formada por las siguientes páginas principales:

| Página | Archivo | Descripción |
|---|---|---|
| Inicio | `index.html` | Página principal de presentación de la empresa. Incluye sección hero, propuesta de valor y acceso a los servicios. |
| Servicios | `services.html` | Catálogo de planes de entrenamiento online ofrecidos por NextRep Training. |
| Sobre nosotros | `aboutUs.html` | Información corporativa sobre la empresa, misión, enfoque y valores. |
| Contacto | `contact.html` | Página con formulario básico para solicitar información o contratar un plan. |

---

## Catálogo de servicios

La página de servicios presenta los planes principales de NextRep Training:

| Plan | Nivel | Objetivo | Precio |
|---|---|---|---|
| Plan Start | Principiante | Crear hábito y mejorar la condición física general | 39,99 € |
| Plan Fat Loss | Principiante–intermedio | Pérdida de grasa y mejora física general | 59,99 € |
| Plan Hypertrophy | Intermedio | Ganancia de masa muscular | 69,99 € |
| Plan Cross Training | Intermedio–avanzado | Mejora del rendimiento general con enfoque funcional | 89,99 € |

---

## Tecnologías utilizadas

La web se ha desarrollado con tecnologías propias del módulo de Lenguajes de Marcas:

- **HTML5**: estructura semántica del contenido.
- **CSS3**: diseño visual, maquetación y responsive básico.
- **JavaScript**: interacción básica.
- **Git y GitHub**: control de versiones.

---

## Estructura recomendada de la carpeta web

La carpeta `/web` debe mantener una estructura clara y fácil de revisar:

```text
web/
├── index.html
├── services.html
├── aboutUs.html
├── contact.html
├── style.css
├── main.js
└── assets/
    └── img/
        ├── hero.png
        ├── logo.
        ├── quienesSomos.png
        └── favicon.png
```

---

## Cómo abrir la web

La web es estática, por lo que no necesita servidor ni base de datos para visualizarse.

### Opción 1 — Abrir directamente

1. Clonar o descargar el repositorio.
2. Entrar en la carpeta `web/`.
3. Abrir el archivo `index.html` con el navegador.
4. Navegar por el menú superior entre las páginas.

### Opción 2 — Usar Live Server si se trabaja con VS Code

Aunque el proyecto principal se trabaja con IntelliJ, también se puede visualizar con Live Server:

1. Abrir la carpeta del proyecto en VS Code.
2. Instalar la extensión **Live Server**.
3. Clic derecho sobre `index.html`.
4. Seleccionar **Open with Live Server**.

---

## Relación con el resto del proyecto

La web no se conecta directamente con la base de datos, ya que el alcance del proyecto permite que la parte web sea informativa.

Aun así, está alineada conceptualmente con el resto de módulos:

- La **web** presenta la empresa y sus planes.
- La **base de datos** modela clientes, planes, solicitudes y administradores.
- La **app Java por consola** permite gestionar datos reales mediante JDBC.
- La **documentación** explica cómo instalar, ejecutar y mantener el proyecto.