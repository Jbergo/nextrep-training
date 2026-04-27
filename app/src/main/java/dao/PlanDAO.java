package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Nivel;
import model.Personalizacion;
import model.Plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PlanDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Plan> findAll() {
        List<Plan> planes = new ArrayList<>();
        String query = "SELECT * FROM " + SchemaDB.T_PLANES;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                planes.add(mapResultSetToPlan(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return planes;
    }

    public List<Plan> findByLevel(Nivel nivel) {
        List<Plan> planes = new ArrayList<>();
        String query = "SELECT * FROM " + SchemaDB.T_PLANES +
                " WHERE " + SchemaDB.C_NIVEL_REQUERIDO + " = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nivel.toDb());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                planes.add(mapResultSetToPlan(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return planes;
    }

    public Plan findById(int idPlan) {
        String query = "SELECT * FROM " + SchemaDB.T_PLANES +
                " WHERE " + SchemaDB.C_ID_PLAN + " = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPlan);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPlan(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return null;
    }

    private Plan mapResultSetToPlan(ResultSet rs) throws SQLException {
        return new Plan(
                rs.getInt(SchemaDB.C_ID_PLAN),
                rs.getString(SchemaDB.C_NOMBRE_PLAN),
                rs.getString(SchemaDB.C_TIPO),
                Nivel.fromDb(rs.getString(SchemaDB.C_NIVEL_REQUERIDO)),
                rs.getString(SchemaDB.C_OBJETIVO_PLAN),
                rs.getInt(SchemaDB.C_DURACION_SEMANAS),
                rs.getInt(SchemaDB.C_FRECUENCIA_SESIONES),
                rs.getInt(SchemaDB.C_DURACION_SESION),
                Personalizacion.fromDb(rs.getString(SchemaDB.C_PERSONALIZACION)),
                rs.getString(SchemaDB.C_DESCRIPCION),
                rs.getString(SchemaDB.C_PARA_QUIEN),
                rs.getDouble(SchemaDB.C_PRECIO),
                rs.getBoolean(SchemaDB.C_ACTIVO)
        );
    }
}