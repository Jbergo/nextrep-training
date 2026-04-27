package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Cliente;
import model.Nivel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ClienteDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM " + SchemaDB.T_CLIENTES;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clientes.add(mapResultSetToCliente(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return clientes;
    }

    public Cliente findByEmail(String email) {
        String query = "SELECT * FROM " + SchemaDB.T_CLIENTES +
                " WHERE " + SchemaDB.C_EMAIL_CLIENTE + " = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToCliente(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return null;
    }

    public Cliente findById(int idCliente) {
        String query = "SELECT * FROM " + SchemaDB.T_CLIENTES +
                " WHERE " + SchemaDB.C_ID_CLIENTE + " = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToCliente(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return null;
    }

    public boolean save(Cliente cliente) {
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?,?)",
                SchemaDB.T_CLIENTES, SchemaDB.C_NOMBRE_CLIENTE, SchemaDB.C_APELLIDOS_CLIENTE,
                SchemaDB.C_EMAIL_CLIENTE, SchemaDB.C_TELEFONO, SchemaDB.C_NIVEL,
                SchemaDB.C_OBJETIVO_CLIENTE, SchemaDB.C_FECHA_ALTA);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellidos());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getNivel().toDb());
            preparedStatement.setString(6, cliente.getObjetivo());
            preparedStatement.setString(7, cliente.getFechaAlta().toString());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Cliente cliente) {
        String query = String.format(
                "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
                SchemaDB.T_CLIENTES, SchemaDB.C_NOMBRE_CLIENTE, SchemaDB.C_APELLIDOS_CLIENTE,
                SchemaDB.C_EMAIL_CLIENTE, SchemaDB.C_TELEFONO, SchemaDB.C_NIVEL,
                SchemaDB.C_OBJETIVO_CLIENTE, SchemaDB.C_FECHA_ALTA, SchemaDB.C_ID_CLIENTE);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellidos());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getNivel().toDb());
            preparedStatement.setString(6, cliente.getObjetivo());
            preparedStatement.setString(7, cliente.getFechaAlta().toString());
            preparedStatement.setInt(8, cliente.getIdCliente());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteById(int idCliente) {
        String query = String.format("DELETE FROM %s WHERE %s = ?",
                SchemaDB.T_CLIENTES, SchemaDB.C_ID_CLIENTE);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
            return false;
        }
    }

    private Cliente mapResultSetToCliente(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt(SchemaDB.C_ID_CLIENTE),
                rs.getString(SchemaDB.C_NOMBRE_CLIENTE),
                rs.getString(SchemaDB.C_APELLIDOS_CLIENTE),
                rs.getString(SchemaDB.C_EMAIL_CLIENTE),
                rs.getString(SchemaDB.C_TELEFONO),
                Nivel.fromDb(rs.getString(SchemaDB.C_NIVEL)),
                rs.getString(SchemaDB.C_OBJETIVO_CLIENTE),
                rs.getDate(SchemaDB.C_FECHA_ALTA).toLocalDate()
        );
    }
}