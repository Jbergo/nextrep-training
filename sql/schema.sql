create database nextRep_training;

use nextRep_training;

create table
    clientes (
        id_cliente INT auto_increment primary key,
        nombre varchar(50) not null,
        apellidos varchar(100) not null,
        email varchar(100) not null unique,
        telefono varchar(20),
        nivel varchar(30) not null,
        objetivo varchar(100) not null,
        fecha_alta date not null
    );

create table
    planes (
        id_plan int auto_increment primary key,
        nombre varchar(80) not null,
        tipo varchar(100) not null,
        nivel_requerido enum ('Principiante', 'Intermedio', 'Avanzado') not null,
        objetivo varchar(100) not null,
        duracion_semanas int not null,
        frecuencia_sesiones int not null,
        duracion_sesion int not null,
        personalizacion enum ('Baja', 'Media', 'Alta') not null,
        descripcion text,
        para_quien text,
        precio decimal(8, 2) not null,
        activo boolean not null
    );

create table
    administrador (
        id_admin int auto_increment primary key,
        nombre varchar(50) not null,
        apellidos varchar(100) not null,
        email varchar(100) not null unique
    );

create table
    solicitudes (
        id_solicitud int auto_increment primary key,
        id_cliente int not null,
        id_plan int not null,
        id_admin int,
        fecha_solicitud date not null,
        estado enum ('Pendiente', 'Aprobada', 'Cancelada') not null default 'pendiente',
        comentarios_cliente text,
        notas_internas text,
        constraint fk_solicitud_clientes foreign key (id_cliente) references clientes (id_cliente) on update cascade on delete restrict,
        constraint fk_solicitud_planes foreign key (id_plan) references planes (id_plan) on update cascade on delete restrict,
        constraint fk_solicitud_admin foreign key (id_admin) references administrador (id_admin) on update cascade on delete restrict
    );