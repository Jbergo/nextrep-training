package view;

import model.Estado;
import model.Solicitud;
import model.SolicitudResumen;
import service.SolicitudService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SolicitudMenu {
    private final SolicitudService solicitudService;
    private final Scanner scanner;

    public SolicitudMenu(SolicitudService solicitudService, Scanner scanner) {
        this.solicitudService = solicitudService;
        this.scanner = scanner;
    }

    public void menu() {
        int opcion = -1;

        do {
            System.out.println("""
                    ============================
                    MENÚ SOLICITUDES
                    ============================
                    0. SALIR
                    1. LISTAR SOLICITUDES
                    2. FILTRAR POR ESTADO
                    3. VER SOLICITUDES DE UN CLIENTE
                    4. NUEVA SOLICITUD
                    5. MODIFICAR SOLICITUD
                    6. ELIMINAR SOLICITUD
                    7. VOLVER AL MENÚ PRINCIPAL
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
                    List<SolicitudResumen> solicitudes = solicitudService.listarSolicitudes();
                    if (solicitudes.isEmpty()) {
                        System.out.println("No hay solicitudes registradas");
                    } else {
                        solicitudes.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el estado (PENDIENTE, APROBADA, CANCELADA):");
                    try {
                        Estado estado = Estado.fromDb(scanner.nextLine());
                        List<SolicitudResumen> solicitudes = solicitudService.buscarPorEstado(estado);
                        if (solicitudes.isEmpty()) {
                            System.out.println("No hay solicitudes con ese estado");
                        } else {
                            solicitudes.forEach(System.out::println);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Estado no válido: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Introduce el email del cliente:");
                    String email = scanner.nextLine();
                    List<SolicitudResumen> solicitudes = solicitudService.buscarPorCliente(email);
                    if (solicitudes.isEmpty()) {
                        System.out.println("No se encontraron solicitudes para ese cliente");
                    } else {
                        solicitudes.forEach(System.out::println);
                    }
                }
                case 4 -> {
                    System.out.println("Introduce el email del cliente:");
                    String email = scanner.nextLine();
                    System.out.println("Introduce el nombre del plan:");
                    String nombrePlan = scanner.nextLine();
                    System.out.println("Introduce comentarios:");
                    String comentarios = scanner.nextLine();
                    boolean creada = solicitudService.nuevaSolicitud(
                            email, nombrePlan, LocalDate.now(),
                            Estado.PENDIENTE, comentarios, "");
                    System.out.println(creada
                            ? "Solicitud creada correctamente"
                            : "Error al crear la solicitud");
                }
                case 5 -> {
                    System.out.println("Introduce el ID de la solicitud:");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        Solicitud solicitud = solicitudService.buscarPorId(id);
                        if (solicitud == null) {
                            System.out.println("No se encontró ninguna solicitud con ese ID");
                            break;
                        }
                        System.out.println("Estado actual: " + solicitud.getEstado());
                        System.out.println("Nuevo estado (PENDIENTE, APROBADA, CANCELADA):");
                        try {
                            solicitud.setEstado(Estado.fromDb(scanner.nextLine()));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Estado no válido, se mantiene el actual");
                        }
                        System.out.println("Comentarios actuales: " + solicitud.getComentariosCliente());
                        System.out.println("Nuevos comentarios:");
                        solicitud.setComentariosCliente(scanner.nextLine());
                        System.out.println("Notas internas actuales: " + solicitud.getNotasInternas());
                        System.out.println("Nuevas notas internas:");
                        solicitud.setNotasInternas(scanner.nextLine());
                        boolean modificada = solicitudService.modificarSolicitud(solicitud);
                        System.out.println(modificada
                                ? "Solicitud modificada correctamente"
                                : "Error al modificar la solicitud");
                    } catch (NumberFormatException e) {
                        System.out.println("El ID debe ser un número");
                    }
                }
                case 6 -> {
                    System.out.println("Introduce el ID de la solicitud a eliminar:");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        Solicitud solicitud = solicitudService.buscarPorId(id);
                        if (solicitud == null) {
                            System.out.println("No se encontró ninguna solicitud con ese ID");
                            break;
                        }
                        boolean eliminada = solicitudService.eliminarSolicitud(solicitud);
                        System.out.println(eliminada
                                ? "Solicitud eliminada correctamente"
                                : "Error al eliminar la solicitud");
                    } catch (NumberFormatException e) {
                        System.out.println("El ID debe ser un número");
                    }
                }
                case 7 -> opcion = 0; // salir del bucle y volver al menú anterior
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}