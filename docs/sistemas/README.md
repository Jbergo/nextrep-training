# Módulo de Sistemas Informáticos

# Índice

- [Descripción del módulo](#descripción-del-módulo)
- [Objetivo del documento](#objetivo-del-documento)
- [Relación con el proyecto](#relación-con-el-proyecto)
- [Archivos incluidos](#archivos-incluidos)
  - [`README.md`](#readmemd)
  - [`informe-tecnico.md`](#informe-tecnicomd)
  - [`capturas/`](#capturas)

---

## Descripción del módulo

Este apartado corresponde al módulo de **Sistemas Informáticos** dentro del Proyecto Intermodular de 1.º DAW.

El objetivo de este módulo es documentar el entorno necesario para que el proyecto **NextRep Training** pueda instalarse, ejecutarse y mantenerse correctamente en un equipo local.

No se centra en el desarrollo del código, sino en explicar qué sistema se necesita, qué herramientas deben instalarse, cómo se configura el entorno y cómo se demuestra que el proyecto funciona.

---

## Objetivo del documento

El objetivo principal es que cualquier persona pueda preparar un equipo desde cero y ejecutar las tres partes principales del proyecto:

- La **web corporativa** desarrollada con HTML, CSS y JavaScript.
- La **base de datos relacional** creada con SQL sobre MySQL.
- La **aplicación Java por consola** conectada a la base de datos mediante JDBC.

Para ello se documentan los requisitos del sistema, la instalación del entorno, los usuarios y permisos, las copias de seguridad, el mantenimiento básico y las evidencias de funcionamiento.

---

## Relación con el proyecto

NextRep Training es una empresa ficticia de servicios de entrenamiento online.

Desde el punto de vista de Sistemas Informáticos, el proyecto necesita un entorno local capaz de ejecutar:

| Parte del proyecto | Necesidad técnica |
|---|---|
| Web corporativa | Navegador web |
| Base de datos | MySQL o MariaDB |
| Aplicación Java | JDK, Maven e IntelliJ IDEA |
| Control de versiones | Git y GitHub |

El entorno elegido permite revisar el proyecto completo sin necesidad de servidores externos ni despliegues avanzados.

---

## Archivos incluidos

La documentación del módulo de Sistemas se organiza dentro de la carpeta:

```txt
docs/sistemas/
```

Archivos recomendados:

```txt
docs/sistemas/
├── README.md
├── informe-tecnico.md
└── capturas/
```

### `README.md`

Documento resumen del módulo de Sistemas. Explica qué contiene esta carpeta, qué se evalúa y cómo se relaciona con el proyecto completo.

### `informe-tecnico.md`

Informe principal del módulo. Incluye los requisitos de hardware, sistema operativo, instalación del entorno, ejecución del proyecto, usuarios, permisos, copias de seguridad, mantenimiento y evidencias.

### `capturas/`

Carpeta destinada a guardar imágenes que demuestren que el proyecto funciona correctamente en el entorno indicado.