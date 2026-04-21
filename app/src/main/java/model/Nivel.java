package model;

public enum Nivel {
    PRINCIPIANTE, INTERMEDIO, AVANZADO;

    public static Nivel fromDb(String value) {
        return switch (value.trim().toUpperCase()) {
            case "PRINCIPIANTE" -> PRINCIPIANTE;
            case "INTERMEDIO" -> INTERMEDIO;
            case "AVANZADO" -> AVANZADO;
            default -> throw new IllegalArgumentException("Nivel no válido en BD: " + value);
        };
    }

    public String toDb() {
        return switch (this) {
            case PRINCIPIANTE -> "Principiante";
            case INTERMEDIO -> "Intermedio";
            case AVANZADO -> "Avanzado";
        };
    }
}
