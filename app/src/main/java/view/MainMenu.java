package view;

import dao.AdministradorDAO;
import dao.ClienteDAO;
import dao.PlanDAO;
import dao.SolicitudDAO;
import model.Administrador;
import service.AdministradorService;
import service.ClienteService;
import service.PlanService;
import service.SolicitudService;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void menu(Scanner scanner) {
        int opcion = -1;

        do {
            System.out.println("""
                    ============================
                    MENÚ PRINCIPAL
                    ============================
                    0. SALIR
                    1. GESTIONAR PLANES
                    2. GESTIONAR CLIENTES
                    3. GESTIONAR SOLICITUDES
                    4. INFORMACIÓN DEL ADMINISTRADOR
                    SELECCIONA UNA OPCIÓN:
                    """);

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido");
                opcion = -1;
            }

            switch (opcion) {
                case 0 -> System.out.println("Saliendo del programa");
                case 1 -> new PlanMenu(new PlanService(new PlanDAO()), scanner).menu();
                case 2 -> new ClienteMenu(new ClienteService(new ClienteDAO()), scanner).menu();
                case 3 -> new SolicitudMenu(new SolicitudService(new SolicitudDAO()), scanner).menu();
                case 4 -> {
                    List<Administrador> admins = new AdministradorService(new AdministradorDAO()).listarAdmin();
                    if (admins.isEmpty()) {
                        System.out.println("No hay administradores registrados");
                    } else {
                        admins.forEach(System.out::println);
                    }
                }
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}