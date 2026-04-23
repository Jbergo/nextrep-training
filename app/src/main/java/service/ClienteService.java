package service;

import dao.ClienteDAO;
import model.Cliente;

import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDao;

    public ClienteService(ClienteDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    public List<Cliente> listarClientes() {
        return clienteDao.findAll();
    }

    public Cliente buscarPorEmail(String email) {
        return clienteDao.findByEmail(email);
    }

    public boolean nuevoCliente(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    public boolean modificarCliente(Cliente cliente) {
        return clienteDao.update(cliente);
    }

    public boolean eliminarCliente(Cliente cliente) {
        return clienteDao.deleteById(cliente.getIdCliente());
    }
}
