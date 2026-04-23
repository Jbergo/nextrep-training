package service;

import dao.SolicitudDAO;
import model.Cliente;
import model.Estado;
import model.Solicitud;
import model.SolicitudResumen;

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

    public List<SolicitudResumen> buscarPorCliente(Cliente cliente) {
        return solicitudDao.findByClient(cliente);
    }

    public boolean nuevaSolicitud(Solicitud solicitud) {
        return solicitudDao.save(solicitud);
    }

    public boolean modificarSolicitud(Solicitud solicitud) {
        return solicitudDao.update(solicitud);
    }

    public boolean eliminarSolicitud(Solicitud solicitud) {
        return solicitudDao.deleteById(solicitud.getIdSolicitud());
    }
}
