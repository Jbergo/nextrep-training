/* 1. Listar todos los planes activos */
select
    id_plan,
    nombre,
    nivel_requerido,
    objetivo,
    precio,
    duracion_semanas
from
    planes
where
    activo = true;

/* 2. Buscar planes activos por nivel */
select
    id_plan,
    nombre,
    nivel_requerido,
    precio,
    duracion_semanas
from
    planes
where
    nivel_requerido = 'Intermedio'
    and activo = true;

/* 3. Listar todos los clientes */
select
    id_cliente,
    nombre,
    apellidos,
    email,
    telefono,
    nivel,
    objetivo,
    fecha_alta
from
    clientes;

/* 4. Buscar cliente por email */
select
    id_cliente,
    nombre,
    apellidos,
    email,
    telefono,
    nivel,
    objetivo
from
    clientes
where
    email = 'laura.gomez@example.com';

/* 5. Listar solicitudes con datos de cliente y plan */
select
    s.id_solicitud,
    c.nombre as nombre_cliente,
    c.apellidos,
    p.nombre as nombre_plan,
    s.fecha_solicitud,
    s.estado
from
    solicitudes s
    inner join clientes c on c.id_cliente = s.id_cliente
    inner join planes p on p.id_plan = s.id_plan;

/* 6. Filtrar solicitudes por estado */
select
    id_solicitud,
    id_cliente,
    id_plan,
    fecha_solicitud,
    estado,
    comentarios_cliente,
    notas_internas
from
    solicitudes
where
    estado = 'Pendiente';

/* 7. Ver solicitudes de un cliente concreto */
select
    s.id_solicitud,
    c.nombre,
    c.apellidos,
    p.nombre as nombre_plan,
    s.fecha_solicitud,
    s.estado
from
    solicitudes s
    inner join clientes c on c.id_cliente = s.id_cliente
    inner join planes p on p.id_plan = s.id_plan
where
    s.id_cliente = 2;

/* 8. Contar solicitudes por estado */
select
    estado,
    count(*) as total_solicitudes
from
    solicitudes
group by
    estado;

/* 9. Contar cuántas veces se ha solicitado cada plan */
select
    p.id_plan,
    p.nombre,
    count(*) as num_solicitudes
from
    solicitudes s
    inner join planes p on p.id_plan = s.id_plan
group by
    p.id_plan,
    p.nombre;

/* 10. Ingresos potenciales por plan */
select
    p.id_plan,
    p.nombre,
    p.precio,
    count(*) as num_solicitudes,
    count(*) * p.precio as ingresos_potenciales
from
    solicitudes s
    inner join planes p on p.id_plan = s.id_plan
group by
    p.id_plan,
    p.nombre,
    p.precio;