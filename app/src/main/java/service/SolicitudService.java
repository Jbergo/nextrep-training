package service;

import dao.AdministradorDAO;
import dao.ClienteDAO;
import dao.PlanDAO;
import dao.SolicitudDAO;
import model.*;

import java.time.LocalDate;
import java.util.List;

public class SolicitudService {
    private final SolicitudDAO solicitudDao;

    public SolicitudService(SolicitudDAO solicitudDao) {
        this.solicitudDao = solicitudDao;
    }

    public List<SolicitudResumen> listarSolicitudes() {
        return solicitudDao.findAll();
    }

    public List<SolicitudResumen> buscarPorEstado(Estado estado) {
        return solicitudDao.findByState(estado);
    }

    public List<SolicitudResumen> buscarPorCliente(String email) {
        Cliente cliente = new ClienteService(new ClienteDAO()).buscarPorEmail(email);
        if (cliente == null) return List.of();
        return solicitudDao.findByClient(cliente);
    }

    public Solicitud buscarPorId(int id) {
        return solicitudDao.findById(id);
    }

    public boolean nuevaSolicitud(String email, String nombrePlan, LocalDate fecha, Estado estado, String comentarios, String notasInternas) {
        Cliente cliente = new ClienteService(new ClienteDAO()).buscarPorEmail(email);
        if (cliente == null) {
            System.out.println("No se encontró ningún cliente con ese email");
            return false;
        }

        Plan plan = null;
        for (Plan item : new PlanService(new PlanDAO()).listarPlanes()) {
            if (item.getNombre().equalsIgnoreCase(nombrePlan.trim())) {
                plan = item;
                break;
            }
        }

        if (plan == null) {
            System.out.println("No se encontró ningún plan con ese nombre");
            return false;
        }

        Administrador admin = new AdministradorDAO().findById(1);

        return solicitudDao.save(new Solicitud(cliente, plan, admin, fecha, estado, comentarios, notasInternas));
    }

    public boolean modificarSolicitud(Solicitud solicitud) {
        return solicitudDao.update(solicitud);
    }

    public boolean eliminarSolicitud(Solicitud solicitud) {
        return solicitudDao.deleteById(solicitud.getIdSolicitud());
    }
}