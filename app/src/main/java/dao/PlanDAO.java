package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Nivel;
import model.Personalizacion;
import model.Plan;

import javax.xml.validation.Schema;
import java.lang.classfile.ClassFile;
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
                String nombre = resultSet.getString(SchemaDB.C_NOMBRE_PLAN);
                String tipo = resultSet.getString(SchemaDB.C_TIPO);
                Nivel nivelRequerido = Nivel.fromDb(resultSet.getString(SchemaDB.C_NIVEL_REQUERIDO));
                String objetivo = resultSet.getString(SchemaDB.C_OBJETIVO_PLAN);
                int duracionSemanas = resultSet.getInt(SchemaDB.C_DURACION_SEMANAS);
                int frecuenciaSesiones = resultSet.getInt(SchemaDB.C_FRECUENCIA_SESIONES);
                int duracionSesion = resultSet.getInt(SchemaDB.C_DURACION_SESION);
                Personalizacion personalizacion = Personalizacion.fromDb(resultSet.getString(SchemaDB.C_PERSONALIZACION));
                String descripcion = resultSet.getString(SchemaDB.C_DESCRIPCION);
                String paraQuien = resultSet.getString(SchemaDB.C_PARA_QUIEN);
                double precio = resultSet.getDouble(SchemaDB.C_PRECIO);
                boolean activo = resultSet.getBoolean(SchemaDB.C_ACTIVO);

                planes.add(new Plan(nombre, tipo, nivelRequerido, objetivo, duracionSemanas, frecuenciaSesiones,
                        duracionSesion, personalizacion, descripcion, paraQuien, precio, activo));

            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL");
            System.out.println(e.getMessage());
        }

        return planes;
    }

    public List<Plan> findByLevel(String nivel) {
        List<Plan> planes = new ArrayList<>();
        String query = "SELECT * FROM " + SchemaDB.T_PLANES + " WHERE " + SchemaDB.C_NIVEL_REQUERIDO + " = '" +
                nivel + "'";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString(SchemaDB.C_NOMBRE_PLAN);
                String tipo = resultSet.getString(SchemaDB.C_TIPO);
                Nivel nivelRequerido = Nivel.fromDb(resultSet.getString(SchemaDB.C_NIVEL_REQUERIDO));
                String objetivo = resultSet.getString(SchemaDB.C_OBJETIVO_PLAN);
                int duracionSemanas = resultSet.getInt(SchemaDB.C_DURACION_SEMANAS);
                int frecuenciaSesiones = resultSet.getInt(SchemaDB.C_FRECUENCIA_SESIONES);
                int duracionSesion = resultSet.getInt(SchemaDB.C_DURACION_SESION);
                Personalizacion personalizacion = Personalizacion.fromDb(resultSet.getString(SchemaDB.C_PERSONALIZACION));
                String descripcion = resultSet.getString(SchemaDB.C_DESCRIPCION);
                String paraQuien = resultSet.getString(SchemaDB.C_PARA_QUIEN);
                double precio = resultSet.getDouble(SchemaDB.C_PRECIO);
                boolean activo = resultSet.getBoolean(SchemaDB.C_ACTIVO);

                planes.add(new Plan(nombre, tipo, nivelRequerido, objetivo, duracionSemanas, frecuenciaSesiones,
                        duracionSesion, personalizacion, descripcion, paraQuien, precio, activo));

            }

        } catch (SQLException e) {
            System.out.println("Error en la SQL");
            System.out.println(e.getMessage());
        }

        return planes;
    }
}
