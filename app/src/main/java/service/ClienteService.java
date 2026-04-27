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
        if (email == null || email.isBlank()) {
            System.out.println("El email no puede estar vacío");
            return null;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("El formato del email no es válido");
            return null;
        }

        return clienteDao.findByEmail(email);
    }

    public boolean nuevoCliente(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    public boolean modificarCliente(Cliente cliente) {
        return clienteDao.update(cliente);
    }

    public boolean eliminarCliente(String correo) {
        Cliente cliente = buscarPorEmail(correo);
        return clienteDao.deleteById(cliente.getIdCliente());
    }
}
