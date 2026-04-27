package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AdministradorDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Administrador> findAll() {
        List<Administrador> admins = new ArrayList<>();
        String query = "SELECT * FROM " + SchemaDB.T_ADMINISTRADOR;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admins.add(mapResultSetToAdmin(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return admins;
    }

    public Administrador findById(int idAdmin) {
        String query = "SELECT * FROM " + SchemaDB.T_ADMINISTRADOR +
                " WHERE " + SchemaDB.C_ID_ADMIN + " = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idAdmin);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToAdmin(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return null;
    }

    private Administrador mapResultSetToAdmin(ResultSet rs) throws SQLException {
        return new Administrador(
                rs.getInt(SchemaDB.C_ID_ADMIN),
                rs.getString(SchemaDB.C_NOMBRE_ADMIN),
                rs.getString(SchemaDB.C_APELLIDOS_ADMIN),
                rs.getString(SchemaDB.C_EMAIL_ADMIN)
        );
    }
}