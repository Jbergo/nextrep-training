# Informe técnico de entorno de ejecución — NextRep Training

## Índice

- [1. Introducción](#1-introducción)
- [2. Tipo de sistema donde se ejecuta](#2-tipo-de-sistema-donde-se-ejecuta)
  - [Justificación](#justificación)
- [3. Requisitos de hardware](#3-requisitos-de-hardware)
  - [Requisitos mínimos](#requisitos-mínimos)
  - [Requisitos recomendados](#requisitos-recomendados)
- [4. Sistema operativo recomendado](#4-sistema-operativo-recomendado)
- [5. Software necesario](#5-software-necesario)
- [6. Instalación del entorno](#6-instalación-del-entorno)
  - [6.1. Instalar Git](#61-instalar-git)
  - [6.2. Instalar Java JDK](#62-instalar-java-jdk)
  - [6.3. Instalar IntelliJ IDEA](#63-instalar-intellij-idea)
  - [6.4. Instalar MySQL o MariaDB](#64-instalar-mysql-o-mariadb)
- [7. Instalación del proyecto](#7-instalación-del-proyecto)
  - [7.1. Clonar el repositorio](#71-clonar-el-repositorio)
  - [7.2. Crear la base de datos](#72-crear-la-base-de-datos)
  - [7.3. Probar consultas SQL](#73-probar-consultas-sql)
- [8. Ejecución de la aplicación Java](#8-ejecución-de-la-aplicación-java)
- [9. Ejecución de la web](#9-ejecución-de-la-web)
- [10. Usuarios y permisos](#10-usuarios-y-permisos)
  - [Usuario del sistema](#usuario-del-sistema)
  - [Usuario de base de datos](#usuario-de-base-de-datos)
- [11. Estructura de carpetas y datos](#11-estructura-de-carpetas-y-datos)
- [12. Copias de seguridad](#12-copias-de-seguridad)
- [13. Mantenimiento básico](#13-mantenimiento-básico)
- [14. Evidencias de funcionamiento](#14-evidencias-de-funcionamiento)

---

## 1. Introducción

Este documento describe el entorno técnico necesario para instalar, ejecutar y mantener el proyecto **NextRep Training**, una aplicación intermodular compuesta por una web corporativa, una base de datos relacional y una aplicación Java por consola conectada mediante JDBC.

El objetivo del informe es que cualquier persona pueda preparar un equipo, instalar las herramientas necesarias, crear la base de datos y ejecutar correctamente el proyecto.

---

## 2. Tipo de sistema donde se ejecuta

El proyecto está pensado para ejecutarse en un **PC local de usuario/desarrollo**.

Esta elección es adecuada porque NextRep Training es un proyecto académico de 1.º DAW que no requiere despliegue en servidor real ni acceso público a internet. La web puede abrirse localmente en el navegador, la base de datos puede ejecutarse en local mediante MySQL o MariaDB, y la aplicación Java se ejecuta desde IntelliJ IDEA.

### Justificación

- Permite trabajar de forma sencilla durante el desarrollo.
- No requiere infraestructura avanzada.
- Es suficiente para probar la web, la base de datos y la aplicación Java.
- Facilita la revisión del proyecto por parte de otra persona.

---

## 3. Requisitos de hardware

### Requisitos mínimos

| Componente | Requisito mínimo |
|---|---|
| Procesador | Intel i3 / AMD Ryzen 3 o equivalente |
| Memoria RAM | 4 GB |
| Almacenamiento | 2 GB libres |
| Pantalla | Resolución mínima 1366x768 |
| Conexión a internet | Necesaria para clonar el repositorio y descargar dependencias |

### Requisitos recomendados

| Componente | Requisito recomendado |
|---|---|
| Procesador | Intel i5 / AMD Ryzen 5 o superior |
| Memoria RAM | 8 GB o más |
| Almacenamiento | 5 GB libres |
| Pantalla | Full HD |
| Conexión a internet | Recomendable para GitHub, Maven y documentación |

---

## 4. Sistema operativo recomendado

El proyecto puede ejecutarse en distintos sistemas operativos, pero se recomienda:

- **Windows 10/11**
- **macOS**
- **Linux Ubuntu 22.04 o superior**

Para este proyecto se recomienda especialmente **Windows 10/11 o macOS**, ya que son entornos habituales para estudiantes y permiten instalar fácilmente IntelliJ IDEA, Java, MySQL/MariaDB y Git.

---

## 5. Software necesario

Para ejecutar el proyecto se necesita instalar:

| Software | Uso |
|---|---|
| Git | Clonar el repositorio desde GitHub |
| IntelliJ IDEA | Abrir y ejecutar la aplicación Java |
| JDK 17 o superior | Compilar y ejecutar Java |
| Maven | Gestionar dependencias del proyecto Java |
| MySQL o MariaDB | Crear y gestionar la base de datos |
| Navegador web | Visualizar la web corporativa |

---

## 6. Instalación del entorno

### 6.1. Instalar Git

Git se utiliza para clonar el repositorio desde GitHub y mantener el control de versiones del proyecto.

Comprobar instalación:

```bash
git --version
```

### 6.2. Instalar Java JDK

La aplicación Java necesita un JDK instalado para poder compilarse y ejecutarse.

Comprobar instalación:

```bash
java -version
```

Versión recomendada:

```txt
Java 17 o superior
```

### 6.3. Instalar IntelliJ IDEA

Se recomienda usar **IntelliJ IDEA Community Edition**.

Pasos básicos:

1. Abrir IntelliJ IDEA.
2. Seleccionar `Open`.
3. Abrir la carpeta `app/` del proyecto.
4. Esperar a que Maven cargue las dependencias.
5. Ejecutar la clase `Main.java`.

### 6.4. Instalar MySQL o MariaDB

La base de datos puede ejecutarse con MySQL o MariaDB. En este proyecto se utiliza una base de datos relacional compatible con ambos sistemas.

Comprobar instalación:

```bash
mysql --version
```

Acceder desde terminal:

```bash
mysql -u root -p
```

---

## 7. Instalación del proyecto

### 7.1. Clonar el repositorio

```bash
git clone https://github.com/Jbergo/nextrep-training.git
cd nextrep-training
```

### 7.2. Crear la base de datos

Desde MySQL/MariaDB ejecutar los scripts en este orden:

```sql
source sql/schema.sql;
source sql/seed.sql;
```

El archivo `schema.sql` crea la base de datos y las tablas principales.  
El archivo `seed.sql` inserta datos de ejemplo para poder probar la aplicación.

### 7.3. Probar consultas SQL

```sql
source sql/queries.sql;
```

Este archivo permite comprobar que existen datos y que las relaciones entre tablas funcionan correctamente.

---

## 8. Ejecución de la aplicación Java

1. Abrir IntelliJ IDEA.
2. Abrir la carpeta `app/`.
3. Esperar a que Maven cargue el proyecto.
4. Revisar la configuración de conexión en:

```txt
app/src/main/java/database/DBConnection.java
```

5. Comprobar los datos de conexión:

```txt
Base de datos: nextrep_training
Usuario: root
Contraseña: contraseña local del usuario
Puerto: 3306
```

6. Ejecutar la clase:

```txt
Main.java
```

7. Utilizar el menú de consola para gestionar clientes, planes y solicitudes.

---

## 9. Ejecución de la web

Para abrir la web corporativa:

1. Entrar en la carpeta `web/`.
2. Abrir el archivo:

```txt
index.html
```

3. Navegar por las páginas disponibles desde el menú principal.

La web no necesita servidor para funcionar, ya que está desarrollada con HTML, CSS y JavaScript básico.

---

## 10. Usuarios y permisos

### Usuario del sistema

El usuario principal será el usuario local del equipo donde se ejecute el proyecto.

Debe tener permisos para:

- Instalar software.
- Ejecutar IntelliJ IDEA.
- Acceder a MySQL/MariaDB.
- Leer y modificar archivos del proyecto.

### Usuario de base de datos

Para el entorno local se puede utilizar el usuario `root`, aunque en un entorno profesional sería recomendable crear un usuario específico para la aplicación.

En caso de utilizar otro usuario, habría que actualizar los datos de conexión en `DBConnection.java`.

---

## 11. Estructura de carpetas y datos

El proyecto se organiza en las siguientes carpetas principales:

| Carpeta | Contenido |
|---|---|
| `app/` | Aplicación Java por consola |
| `web/` | Web corporativa |
| `sql/` | Scripts de base de datos |
| `docs/` | Documentación del proyecto |
| `diagrams/` | Diagramas del proyecto |
| `assets/` | Recursos gráficos generales |

Los datos principales se almacenan en la base de datos `nextrep_training`.

---

## 12. Copias de seguridad

Para realizar una copia de seguridad de la base de datos:

```bash
mysqldump -u root -p nextrep_training > backup_nextrep_training.sql
```

Para restaurarla:

```bash
mysql -u root -p nextrep_training < backup_nextrep_training.sql
```

---

## 13. Mantenimiento básico

Tareas recomendadas de mantenimiento:

- Revisar que los scripts SQL se ejecutan sin errores.
- Mantener actualizado el README principal del repositorio.
- Comprobar que la aplicación Java sigue conectando correctamente con la base de datos.
- Revisar que no se suben archivos innecesarios al repositorio.
- Comprobar que la web mantiene enlaces funcionales.
- Hacer commits frecuentes y descriptivos.
- Realizar copias de seguridad de la base de datos si se modifican datos importantes.

---

## 14. Evidencias de funcionamiento

Para demostrar que el proyecto funciona, se incluirán capturas en la carpeta:

```txt
docs/sistemas/capturas/
```

| Nº | Evidencia | Archivo |
|---|---|---|
| 1 | Repositorio clonado en local | `capturas/01-repositorio-clonado.png` |
| 2 | Base de datos creada | `capturas/02-base-datos-creada.png` |
| 3 | Tablas creadas con datos insertados | `capturas/03-tablas-con-datos.png` |
| 4 | Ejecución de consultas SQL | `capturas/04-consultas-sql.png` |
| 5 | Proyecto abierto en IntelliJ | `capturas/05-intellij-proyecto.png` |
| 6 | Aplicación Java ejecutándose | `capturas/06-app-java-menu-principal.png` |
| 7 | Menú principal de la aplicación web | `capturas/07-web-navegador.png` |