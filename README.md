# NextRep Training

## Índice

- [Descripción del proyecto](#descripción-del-proyecto)
- [Para qué sirve](#para-qué-sirve)
  - [Público objetivo resumido](#público-objetivo-resumido)
- [Problema que resuelve](#problema-que-resuelve)
- [Tecnologías](#tecnologías)
- [Funcionalidades principales](#funcionalidades-principales)
  - [Web corporativa](#web-corporativa)
  - [Base de datos](#base-de-datos)
  - [Aplicación Java por consola](#aplicación-java-por-consola)
- [Estructura del repositorio](#estructura-del-repositorio)
- [Instalación y ejecución](#instalación-y-ejecución)
  - [1. Clonar el repositorio](#1-clonar-el-repositorio)
  - [2. Crear la base de datos](#2-crear-la-base-de-datos)
  - [3. Probar consultas SQL](#3-probar-consultas-sql)
  - [4. Configurar la conexión JDBC](#4-configurar-la-conexión-jdbc)
  - [5. Ejecutar la aplicación Java](#5-ejecutar-la-aplicación-java)
  - [6. Abrir la web](#6-abrir-la-web)
- [Scripts SQL](#scripts-sql)
- [Arquitectura Java](#arquitectura-java)
- [Mejora MPO](#mejora-mpo)
- [Autor](#autor)

---

## Descripción del proyecto

**NextRep Training** es un proyecto intermodular de 1.º DAW que integra los módulos de Bases de Datos, Programación, Lenguajes de Marcas, Entornos de Desarrollo, Sistemas Informáticos y MPO. La propuesta consiste en desarrollar una **web corporativa** que presente la empresa y sus servicios, una **base de datos relacional** que modele la información del negocio y una **aplicación Java conectada mediante JDBC** para gestionar datos reales de clientes, planes y solicitudes.

La finalidad general del proyecto es que el usuario pueda consultar planes de entrenamiento según su nivel y objetivo, conocer las características de cada servicio y solicitar su contratación. Al mismo tiempo, la empresa podrá gestionar internamente esa información de forma estructurada.

---

## Para qué sirve

- Presentar la empresa y su propuesta de valor.
- Mostrar un catálogo de servicios de entrenamiento online.
- Explicar cada servicio de forma clara.
- Permitir que un cliente solicite la contratación de un plan.
- Registrar dichas solicitudes en una base de datos.
- Facilitar una gestión básica de servicios y contrataciones desde una parte administrativa.

### Público objetivo resumido

Adultos jóvenes y de mediana edad interesados en mejorar su condición física mediante programas de entrenamiento online personalizados.

---

## Problema que resuelve

**NextRep Training** responde a una necesidad frecuente: muchas personas quieren entrenar, pero no saben cómo organizar una rutina adecuada, qué plan elegir o cómo adaptar el entrenamiento a su nivel real.

Frente a ese problema, la empresa ofrece una solución digital clara y accesible, basada en un catálogo de planes comprensible y en un sistema de gestión coherente con el negocio.

---

## Tecnologías

- **HTML5**, para la estructura y el contenido de las páginas web.
- **CSS3**, para el diseño visual, la maquetación y la adaptación responsive.
- **JavaScript**, para aportar interactividad básica en formularios y componentes de la interfaz.
- **Java**, como lenguaje principal para la lógica de la aplicación.
- **JDBC**, para la conexión entre la aplicación Java y la base de datos.
- **SQL**, para la creación, consulta y gestión de los datos.
- **MySQL**, como sistema gestor de base de datos relacional.
- **Git y GitHub**, para el control de versiones y la organización del repositorio del proyecto.

---

## Funcionalidades principales

### Web corporativa

- Página de inicio.
- Página de servicios/planes.
- Página sobre la empresa.
- Página de contacto.
- Navegación funcional.
- Diseño responsive básico.
- JavaScript básico para navegación.

### Base de datos

- Gestión de clientes.
- Gestión de planes de entrenamiento.
- Gestión de solicitudes.
- Gestión de administradores.
- Scripts SQL de creación, inserción y consultas.
- Consultas útiles con filtros y relaciones entre tablas.

### Aplicación Java por consola

- Conexión real a base de datos mediante JDBC.
- Menú principal por consola.
- Listado de planes.
- CRUD de clientes.
- CRUD de solicitudes.
- Consultas relacionadas entre clientes, planes y solicitudes.
- Validaciones básicas y gestión de errores.

---

## Estructura del repositorio

```txt
nextrep-training/
├── app/
│   ├── pom.xml
│   └── src/main/java/
│       ├── dao/
│       ├── database/
│       ├── model/
│       ├── service/
│       ├── view/
│       └── Main.java
├── assets/
├── diagrams/
├── docs/
│   ├── bbdd/
│   ├── mpo/
│   ├── programming/
│   ├── project/
│   └── sistemas/
├── sql/
│   ├── schema.sql
│   ├── seed.sql
│   └── queries.sql
├── web/
│   ├── index.html
│   ├── services.html
│   ├── aboutUs.html
│   ├── contact.html
│   ├── style.css
│   ├── main.js
│   └── assets/
│       └── img/
└── README.md
```

---

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/Jbergo/nextrep-training.git
cd nextrep-training
```

---

### 2. Crear la base de datos

Abrir MariaDB o MySQL y ejecutar los scripts SQL en este orden:

```sql
source sql/schema.sql;
source sql/seed.sql;
```

También se pueden abrir los archivos desde un cliente gráfico como DBeaver, HeidiSQL, MySQL Workbench o el propio gestor de base de datos de IntelliJ.

---

### 3. Probar consultas SQL

Para comprobar que los datos se han creado correctamente:

```sql
source sql/queries.sql;
```

El archivo `queries.sql` contiene consultas útiles para listar planes, clientes, solicitudes y obtener información relacionada mediante JOIN.

---

### 4. Configurar la conexión JDBC

Abrir el proyecto Java desde IntelliJ usando la carpeta:

```txt
app/
```

Comprobar los datos de conexión en la clase de conexión JDBC:

```txt
app/src/main/java/database/DBConnection.java
```

Datos habituales de conexión local:

```txt
Base de datos: nextrep_training
Usuario: root
Contraseña: la configurada en MariaDB/MySQL
Puerto: 3306
```

Si el usuario o contraseña son diferentes, deben modificarse en la clase de conexión.

---

### 5. Ejecutar la aplicación Java

Desde IntelliJ:

1. Abrir la carpeta `app/`.
2. Esperar a que Maven cargue las dependencias.
3. Comprobar que el driver JDBC está disponible.
4. Ejecutar la clase `Main.java`.
5. Usar el menú de consola para gestionar la información.

---

### 6. Abrir la web

Abrir el archivo:

```txt
web/index.html
```

Se puede abrir directamente en el navegador o mediante la opción “Open in Browser” del editor.

---

## Scripts SQL

| Archivo | Función |
|---|---|
| `schema.sql` | Crea la base de datos y las tablas principales |
| `seed.sql` | Inserta datos iniciales de ejemplo |
| `queries.sql` | Contiene consultas útiles para comprobar el funcionamiento |

---

## Arquitectura Java

La aplicación Java está organizada por capas para separar responsabilidades:

| Paquete | Responsabilidad |
|---|---|
| `model` | Clases que representan las entidades del negocio |
| `dao` | Acceso a datos mediante JDBC |
| `service` | Lógica de negocio y validaciones |
| `view` | Menús e interacción por consola |
| `database` | Configuración de la conexión con la base de datos |
| `Main.java` | Punto de entrada de la aplicación |

---

## Mejora MPO

Como mejora estructural se ha aplicado una arquitectura por capas, separando la interfaz de consola, la lógica de negocio, el acceso a datos y los modelos.

También se utilizan enums y validaciones básicas para mejorar la mantenibilidad, evitar valores incorrectos y facilitar futuras ampliaciones del proyecto.

---

## Autor

Jorge Bermúdez Gómez