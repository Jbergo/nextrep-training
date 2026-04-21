package model;

public enum Estado {
    PENDIENTE, APROBADA, CANCELADA;

    public static Estado fromDb(String value) {
        return switch (value.trim().toUpperCase()) {
            case "PENDIENTE" -> PENDIENTE;
            case "APROBADA" -> APROBADA;
            case "CANCELADA" -> CANCELADA;
            default -> throw new IllegalArgumentException("Estado no válido en BD: " + value);
        };
    }

    public String toDb() {
        return switch (this) {
            case PENDIENTE -> "Pendiente";
            case APROBADA -> "Aprobada";
            case CANCELADA -> "Cancelada";
        };
    }
}
