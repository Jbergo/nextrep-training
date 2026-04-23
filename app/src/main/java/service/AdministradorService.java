package service;

import dao.AdministradorDAO;
import model.Administrador;

import java.util.List;

public class AdministradorService {
    private final AdministradorDAO adminDao;

    public AdministradorService(AdministradorDAO adminDao) {
        this.adminDao = adminDao;
    }

    public List<Administrador> listarAdmin() {
        return adminDao.findAll();
    }
}
