package model;

public enum Personalizacion {
    BAJA, MEDIA, ALTA;

    public static Personalizacion fromDb(String value) {
        return switch (value.trim().toUpperCase()) {
            case "BAJA" -> BAJA;
            case "MEDIA" -> MEDIA;
            case "ALTA" -> ALTA;
            default -> throw new IllegalArgumentException("Personalización no válida en BD: " + value);
        };
    }

    public String toDb() {
        return switch (this) {
            case BAJA -> "Baja";
            case MEDIA -> "Media";
            case ALTA -> "Alta";
        };
    }
}
