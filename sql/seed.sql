/*PLANES DE EJEMPLO*/
INSERT INTO
    planes (
        nombre,
        tipo,
        nivel_requerido,
        objetivo,
        duracion_semanas,
        frecuencia_sesiones,
        duracion_sesion,
        personalizacion,
        descripcion,
        para_quien,
        precio,
        activo
    )
VALUES
    (
        'Plan Start',
        'Iniciación al entrenamiento',
        'Principiante',
        'Mejorar la condición física general',
        4,
        3,
        45,
        'Baja',
        'Planificación semanal básica y progresiva.',
        'Usuarios principiantes que necesitan una guía inicial.',
        39.99,
        1
    ),
    (
        'Plan Fat Loss',
        'Acondicionamiento general',
        'Principiante',
        'Pérdida de grasa y mejora de la condición física general',
        8,
        4,
        45,
        'Media',
        'Rutina enfocada en constancia, gasto energético y mejora física global.',
        'Personas que quieren perder grasa y mejorar su condición física general.',
        59.99,
        1
    ),
    (
        'Plan Hypertrophy',
        'Fuerza e hipertrofia',
        'Intermedio',
        'Ganancia de masa muscular',
        8,
        5,
        60,
        'Media',
        'Programación estructurada para hipertrofia.',
        'Usuarios intermedios que buscan ganar masa muscular.',
        69.99,
        1
    ),
    (
        'Plan Cross Training',
        'CrossFit / entrenamiento funcional',
        'Intermedio',
        'Mejorar el rendimiento general y la capacidad de trabajo',
        6,
        5,
        60,
        'Alta',
        'Programación orientada al rendimiento general y al entrenamiento funcional.',
        'Usuarios intermedios o avanzados con enfoque cercano al CrossFit.',
        89.99,
        1
    );

/*CLIENTES DE EJEMPLO*/
INSERT INTO
    clientes (
        nombre,
        apellidos,
        email,
        telefono,
        nivel,
        objetivo,
        fecha_alta
    )
VALUES
    (
        'Carlos',
        'Martínez López',
        'carlos.martinez@example.com',
        '611223344',
        'Principiante',
        'Pérdida de grasa',
        '2026-04-01'
    ),
    (
        'Laura',
        'Gómez Sánchez',
        'laura.gomez@example.com',
        '622334455',
        'Intermedio',
        'Ganancia de masa muscular',
        '2026-04-02'
    ),
    (
        'David',
        'Fernández Ruiz',
        'david.fernandez@example.com',
        '633445566',
        'Principiante',
        'Mejorar condición física',
        '2026-04-03'
    ),
    (
        'Marta',
        'Pérez Díaz',
        'marta.perez@example.com',
        '644556677',
        'Avanzado',
        'Mejorar rendimiento general',
        '2026-04-04'
    ),
    (
        'Sergio',
        'Navarro Torres',
        'sergio.navarro@example.com',
        '655667788',
        'Intermedio',
        'Ganancia de masa muscular',
        '2026-04-05'
    ),
    (
        'Ana',
        'Romero Gil',
        'ana.romero@example.com',
        '666778899',
        'Principiante',
        'Crear hábito de entrenamiento',
        '2026-04-06'
    );

/*ADMINISTRADOR DE EJEMPLO*/
INSERT INTO
    administrador (nombre, apellidos, email)
VALUES
    ('Admin', 'NextRep', 'admin@nextreptraining.com');

/*SOLICITUDES DE EJEMPLO*/
INSERT INTO
    solicitudes (
        id_cliente,
        id_plan,
        id_admin,
        fecha_solicitud,
        estado,
        comentarios_cliente,
        notas_internas
    )
VALUES
    (
        1,
        2,
        1,
        '2026-04-07',
        'Pendiente',
        'Quiere un plan para perder grasa y entrenar 4 días por semana.',
        'Primera toma de contacto pendiente de revisión.'
    ),
    (
        2,
        3,
        1,
        '2026-04-08',
        'Aprobada',
        'Busca un plan de hipertrofia con progresión de cargas.',
        'Cliente adecuado para Plan Hypertrophy.'
    ),
    (
        3,
        1,
        1,
        '2026-04-08',
        'Pendiente',
        'Es principiante y necesita una estructura sencilla para empezar.',
        'Posible cierre rápido, perfil muy alineado con Plan Start.'
    ),
    (
        4,
        4,
        1,
        '2026-04-09',
        'Pendiente',
        'Quiere mejorar rendimiento general con enfoque funcional.',
        'Revisar disponibilidad y experiencia previa antes de confirmar.'
    ),
    (
        5,
        3,
        1,
        '2026-04-10',
        'Aprobada',
        'Objetivo principal: ganar masa muscular.',
        'Solicitud validada correctamente.'
    ),
    (
        6,
        1,
        1,
        '2026-04-10',
        'Cancelada',
        'Quiere empezar a entrenar pero tiene dudas sobre la frecuencia.',
        'Se recomienda reformular objetivos antes de asignar plan.'
    );