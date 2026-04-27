package view;

import model.Nivel;
import model.Plan;
import service.PlanService;

import java.util.List;
import java.util.Scanner;

public class PlanMenu {
    private final PlanService planService;
    private final Scanner scanner;

    public PlanMenu(PlanService planService, Scanner scanner) {
        this.planService = planService;
        this.scanner = scanner;
    }

    public void menu() {
        int opcion = -1;

        do {
            System.out.println("""
                    ============================
                    MENÚ PLANES
                    ============================
                    0. SALIR
                    1. LISTAR PLANES
                    2. BUSCAR PLANES POR NIVEL
                    3. VOLVER AL MENÚ PRINCIPAL
                    SELECCIONA UNA OPCIÓN:
                    """);

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número válido");
                opcion = -1;
            }

            switch (opcion) {
                case 0 -> System.out.println("Saliendo del programa");
                case 1 -> {
                    List<Plan> planes = planService.listarPlanes();
                    if (planes.isEmpty()) {
                        System.out.println("No hay planes registrados");
                    } else {
                        planes.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.println("Nivel (PRINCIPIANTE, INTERMEDIO, AVANZADO):");
                    try {
                        Nivel nivel = Nivel.fromDb(scanner.nextLine());
                        List<Plan> planes = planService.buscarPorNivel(nivel);
                        if (planes.isEmpty()) {
                            System.out.println("No hay planes para ese nivel");
                        } else {
                            planes.forEach(System.out::println);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Nivel no válido: " + e.getMessage());
                    }
                }
                case 3 -> opcion = 0;
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}