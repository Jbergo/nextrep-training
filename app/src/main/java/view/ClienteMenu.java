package view;

import model.Cliente;
import model.Nivel;
import service.ClienteService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClienteMenu {
    private final ClienteService clienteService;
    private final Scanner scanner;

    public ClienteMenu(ClienteService clienteService, Scanner scanner) {
        this.clienteService = clienteService;
        this.scanner = scanner;
    }

    public void menu() {
        int opcion = -1;

        do {
            System.out.println("""
                    ============================
                    MENÚ CLIENTES
                    ============================
                    0. SALIR
                    1. LISTAR CLIENTES
                    2. BUSCAR CLIENTE POR EMAIL
                    3. NUEVO CLIENTE
                    4. MODIFICAR CLIENTE
                    5. ELIMINAR CLIENTE
                    6. VOLVER AL MENÚ PRINCIPAL
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
                    List<Cliente> clientes = clienteService.listarClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados");
                    } else {
                        clientes.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el email del cliente:");
                    Cliente cliente = clienteService.buscarPorEmail(scanner.nextLine());
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado");
                    } else {
                        System.out.println(cliente);
                    }
                }
                case 3 -> {
                    System.out.println("Nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Apellidos:");
                    String apellidos = scanner.nextLine();
                    System.out.println("Email:");
                    String email = scanner.nextLine();
                    System.out.println("Teléfono:");
                    String telefono = scanner.nextLine();
                    System.out.println("Nivel (PRINCIPIANTE, INTERMEDIO, AVANZADO):");
                    try {
                        Nivel nivel = Nivel.fromDb(scanner.nextLine());
                        System.out.println("Objetivo:");
                        String objetivo = scanner.nextLine();
                        boolean creado = clienteService.nuevoCliente(
                                new Cliente(nombre, apellidos, email, telefono, nivel, objetivo, LocalDate.now()));
                        System.out.println(creado
                                ? "Cliente añadido correctamente"
                                : "Error al añadir el cliente");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Nivel no válido: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Introduce el email del cliente a modificar:");
                    String email = scanner.nextLine();
                    Cliente cliente = clienteService.buscarPorEmail(email);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado");
                        break;
                    }
                    System.out.println("Nuevo teléfono (actual: " + cliente.getTelefono() + "):");
                    cliente.setTelefono(scanner.nextLine());
                    System.out.println("Nuevo nivel (actual: " + cliente.getNivel() + "):");
                    try {
                        cliente.setNivel(Nivel.fromDb(scanner.nextLine()));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Nivel no válido, se mantiene el actual");
                    }
                    System.out.println("Nuevo objetivo (actual: " + cliente.getObjetivo() + "):");
                    cliente.setObjetivo(scanner.nextLine());
                    boolean modificado = clienteService.modificarCliente(cliente);
                    System.out.println(modificado
                            ? "Cliente modificado correctamente"
                            : "Error al modificar el cliente");
                }
                case 5 -> {
                    System.out.println("Introduce el email del cliente a eliminar:");
                    String correo = scanner.nextLine();
                    boolean eliminado = clienteService.eliminarCliente(correo);
                    System.out.println(eliminado
                            ? "Cliente eliminado correctamente"
                            : "Error al eliminar el cliente");
                }
                case 6 -> opcion = 0; // salir del bucle y volver al menú anterior
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}