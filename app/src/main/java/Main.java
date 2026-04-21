import dao.AdministradorDAO;
import dao.ClienteDAO;
import dao.PlanDAO;
import model.Cliente;
import model.Nivel;

import java.time.LocalDate;

import static database.DBConnection.getConnection;

public class Main {
    public static void main(String[] args) {
        ClienteDAO cliente = new ClienteDAO();
        Cliente clientePrueba = new Cliente(
                9,
                "actualizar",
                "actualizar",
                "actualizar@example.com",
                "actualizar",
                Nivel.AVANZADO,
                "actualizar",
                LocalDate.of(2026, 4, 21)
        );

        System.out.println(cliente.deleteById(9));
    }
}
