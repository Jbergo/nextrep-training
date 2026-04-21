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
                String nombre = resultSet.getString(SchemaDB.C_NOMBRE_ADMIN);
                String apellidos = resultSet.getString(SchemaDB.C_APELLIDOS_ADMIN);
                String email = resultSet.getString(SchemaDB.C_EMAIL_ADMIN);

                admins.add(new Administrador(nombre, apellidos, email));
            }

        } catch (SQLException e) {
            System.out.println("Error en la SQL");
            System.out.println(e.getMessage());
        }

        return admins;
    }
}
