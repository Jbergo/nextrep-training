package model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SolicitudResumen {
    private int idSolicitud;
    private String nombreCliente;
    private String apellidosCliente;
    private String nombrePlan;
    private LocalDate fechaSolicitud;
    private Estado estado;
}
