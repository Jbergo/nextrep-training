package database;

public interface SchemaDB {

    String T_CLIENTES = "clientes";
    String T_PLANES = "planes";
    String T_SOLICITUDES = "solicitudes";
    String T_ADMINISTRADOR = "administrador";

    String C_ID_CLIENTE = "id_cliente";
    String C_NOMBRE_CLIENTE = "nombre";
    String C_APELLIDOS_CLIENTE = "apellidos";
    String C_EMAIL_CLIENTE = "email";
    String C_TELEFONO = "telefono";
    String C_NIVEL = "nivel";
    String C_OBJETIVO_CLIENTE = "objetivo";
    String C_FECHA_ALTA = "fecha_alta";

    String C_ID_PLAN = "id_plan";
    String C_NOMBRE_PLAN = "nombre";
    String C_TIPO = "tipo";
    String C_NIVEL_REQUERIDO = "nivel_requerido";
    String C_OBJETIVO_PLAN = "objetivo";
    String C_DURACION_SEMANAS = "duracion_semanas";
    String C_FRECUENCIA_SESIONES = "frecuencia_sesiones";
    String C_DURACION_SESION = "duracion_sesion";
    String C_PERSONALIZACION = "personalizacion";
    String C_DESCRIPCION = "descripcion";
    String C_PARA_QUIEN = "para_quien";
    String C_PRECIO = "precio";
    String C_ACTIVO = "activo";

    String C_ID_SOLICITUD = "id_solicitud";
    String C_FECHA_SOLICITUD = "fecha_solicitud";
    String C_ESTADO = "estado";
    String C_COMENTARIOS_CLIENTE = "comentarios_cliente";
    String C_NOTAS_INTERNAS = "notas_internas";

    String C_ID_ADMIN = "id_admin";
    String C_NOMBRE_ADMIN = "nombre";
    String C_APELLIDOS_ADMIN = "apellidos";
    String C_EMAIL_ADMIN = "email";

}