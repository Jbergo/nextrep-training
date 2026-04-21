package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Plan {
    private int idPlan;
    private String nombre;
    private String tipo;
    private Nivel nivelRequerido;
    private String objetivo;
    private int duracionSemanas;
    private int frecuenciaSesiones;
    private int duracionSesion;
    private Personalizacion personalizacion;
    private String descripcion;
    private String paraQuien;
    private double precio;
    private boolean activo;

    public Plan(String nombre, String tipo, Nivel nivelRequerido, String objetivo, int duracionSemanas, int frecuenciaSesiones, int duracionSesion, Personalizacion personalizacion, String descripcion, String paraQuien, double precio, boolean activo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivelRequerido = nivelRequerido;
        this.objetivo = objetivo;
        this.duracionSemanas = duracionSemanas;
        this.frecuenciaSesiones = frecuenciaSesiones;
        this.duracionSesion = duracionSesion;
        this.personalizacion = personalizacion;
        this.descripcion = descripcion;
        this.paraQuien = paraQuien;
        this.precio = precio;
        this.activo = activo;
    }
}
