import dao.AdministradorDAO;
import dao.ClienteDAO;
import dao.PlanDAO;
import dao.SolicitudDAO;
import model.*;

import java.time.LocalDate;

import static database.DBConnection.getConnection;

public class Main {
    public static void main(String[] args) {
        SolicitudDAO solicitudDAO = new SolicitudDAO();

        Plan planPrueba = new Plan(
                1,
                "Prueba",
                "prueba",
                Nivel.AVANZADO,
                "prueba",
                2,
                2,
                2,
                Personalizacion.ALTA,
                "prueba",
                "prueba",
                69.99,
                true
        );



        Cliente clientePrueba = new Cliente(

                1,

                "prueba",

                "prueba",

                "prueba@example.com",

                "prueba",

                Nivel.PRINCIPIANTE,

                "prueba",

                LocalDate.of(2026, 4, 23)

        );

        Administrador adminPrueba = new Administrador(
                1,
                "prueba",
                "prueba",
                "prueba"
        );

        Solicitud solicitudPrueba = new Solicitud(
                7,
                clientePrueba,
                planPrueba,
                adminPrueba,
                LocalDate.of(2020, 3, 23),
                Estado.PENDIENTE,
                "pruebaACTUALIZADA",
                "pruebaACTUALIZADA"
        );

        System.out.println(solicitudDAO.deleteById(7));
    }


}
