package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Administrador {
    private int idAdmin;
    private String nombre;
    private String apellidos;
    private String email;

    public Administrador(String email, String apellidos, String nombre) {
        this.email = email;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }
}