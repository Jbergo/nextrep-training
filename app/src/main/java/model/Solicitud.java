package model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Solicitud {
    private int idSolicitud;
    private Cliente cliente;
    private Plan plan;
    private Administrador admin;
    private LocalDate fechaSolicitud;
    private Estado estado;
    private String comentariosCliente;
    private String notasInternas;

    public Solicitud(Cliente cliente, Plan plan, Administrador admin, LocalDate fechaSolicitud, Estado estado, String comentariosCliente, String notasInternas) {
        this.cliente = cliente;
        this.plan = plan;
        this.admin = admin;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.comentariosCliente = comentariosCliente;
        this.notasInternas = notasInternas;
    }
}
