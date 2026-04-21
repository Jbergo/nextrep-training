package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private Nivel nivel;
    private String objetivo;
    private LocalDate fechaAlta;

    public Cliente(String nombre, String apellidos, String email, String telefono, Nivel nivel, String objetivo, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.nivel = nivel;
        this.objetivo = objetivo;
        this.fechaAlta = fechaAlta;
    }
}
