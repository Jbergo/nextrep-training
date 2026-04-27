package dao;

import database.DBConnection;
import database.SchemaDB;
import model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SolicitudDAO() {
        connection = DBConnection.getConnection();
    }

    public List<SolicitudResumen> findAll() {
        List<SolicitudResumen> solicitudes = new ArrayList<>();
        String query = String.format("""
                SELECT s.%s, c.%s AS nombre_cliente, c.%s,
                       p.%s AS nombre_plan, s.%s, s.%s
                FROM %s s
                INNER JOIN %s c ON c.%s = s.%s
                INNER JOIN %s p ON p.%s = s.%s
                """,
                SchemaDB.C_ID_SOLICITUD, SchemaDB.C_NOMBRE_CLIENTE, SchemaDB.C_APELLIDOS_CLIENTE,
                SchemaDB.C_NOMBRE_PLAN, SchemaDB.C_FECHA_SOLICITUD, SchemaDB.C_ESTADO,
                SchemaDB.T_SOLICITUDES,
                SchemaDB.T_CLIENTES, SchemaDB.C_ID_CLIENTE, SchemaDB.C_ID_CLIENTE,
                SchemaDB.T_PLANES, SchemaDB.C_ID_PLAN, SchemaDB.C_ID_PLAN);

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(mapResultSetToResumen(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return solicitudes;
    }

    public List<SolicitudResumen> findByState(Estado estado) {
        List<SolicitudResumen> solicitudes = new ArrayList<>();
        String query = String.format("""
                SELECT s.%s, c.%s AS nombre_cliente, c.%s,
                       p.%s AS nombre_plan, s.%s, s.%s
                FROM %s s
                INNER JOIN %s c ON c.%s = s.%s
                INNER JOIN %s p ON p.%s = s.%s
                WHERE s.%s = ?
                """,
                SchemaDB.C_ID_SOLICITUD, SchemaDB.C_NOMBRE_CLIENTE, SchemaDB.C_APELLIDOS_CLIENTE,
                SchemaDB.C_NOMBRE_PLAN, SchemaDB.C_FECHA_SOLICITUD, SchemaDB.C_ESTADO,
                SchemaDB.T_SOLICITUDES,
                SchemaDB.T_CLIENTES, SchemaDB.C_ID_CLIENTE, SchemaDB.C_ID_CLIENTE,
                SchemaDB.T_PLANES, SchemaDB.C_ID_PLAN, SchemaDB.C_ID_PLAN,
                SchemaDB.C_ESTADO);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, estado.toDb());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(mapResultSetToResumen(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return solicitudes;
    }

    public List<SolicitudResumen> findByClient(Cliente cliente) {
        List<SolicitudResumen> solicitudes = new ArrayList<>();
        String query = String.format("""
                SELECT s.%s, c.%s AS nombre_cliente, c.%s,
                       p.%s AS nombre_plan, s.%s, s.%s
                FROM %s s
                INNER JOIN %s c ON c.%s = s.%s
                INNER JOIN %s p ON p.%s = s.%s
                WHERE s.%s = ?
                """,
                SchemaDB.C_ID_SOLICITUD, SchemaDB.C_NOMBRE_CLIENTE, SchemaDB.C_APELLIDOS_CLIENTE,
                SchemaDB.C_NOMBRE_PLAN, SchemaDB.C_FECHA_SOLICITUD, SchemaDB.C_ESTADO,
                SchemaDB.T_SOLICITUDES,
                SchemaDB.T_CLIENTES, SchemaDB.C_ID_CLIENTE, SchemaDB.C_ID_CLIENTE,
                SchemaDB.T_PLANES, SchemaDB.C_ID_PLAN, SchemaDB.C_ID_PLAN,
                SchemaDB.C_ID_CLIENTE);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cliente.getIdCliente());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(mapResultSetToResumen(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return solicitudes;
    }

    public Solicitud findById(int idSolicitud) {
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.T_SOLICITUDES, SchemaDB.C_ID_SOLICITUD);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idSolicitud);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Cliente cliente = new ClienteDAO().findById(resultSet.getInt(SchemaDB.C_ID_CLIENTE));
                Plan plan = new PlanDAO().findById(resultSet.getInt(SchemaDB.C_ID_PLAN));
                Administrador admin = new AdministradorDAO().findById(resultSet.getInt(SchemaDB.C_ID_ADMIN));
                LocalDate fecha = resultSet.getDate(SchemaDB.C_FECHA_SOLICITUD).toLocalDate();
                Estado estado = Estado.fromDb(resultSet.getString(SchemaDB.C_ESTADO));
                String comentarios = resultSet.getString(SchemaDB.C_COMENTARIOS_CLIENTE);
                String notas = resultSet.getString(SchemaDB.C_NOTAS_INTERNAS);

                return new Solicitud(idSolicitud, cliente, plan, admin, fecha, estado, comentarios, notas);
            }
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
        }
        return null;
    }

    public boolean save(Solicitud solicitud) {
        if (solicitud.getCliente() == null || solicitud.getPlan() == null) {
            System.out.println("Error: cliente o plan no encontrado");
            return false;
        }

        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?,?)",
                SchemaDB.T_SOLICITUDES, SchemaDB.C_ID_CLIENTE, SchemaDB.C_ID_PLAN,
                SchemaDB.C_ID_ADMIN, SchemaDB.C_FECHA_SOLICITUD, SchemaDB.C_ESTADO,
                SchemaDB.C_COMENTARIOS_CLIENTE, SchemaDB.C_NOTAS_INTERNAS);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, solicitud.getCliente().getIdCliente());
            preparedStatement.setInt(2, solicitud.getPlan().getIdPlan());
            if (solicitud.getAdmin() != null) {
                preparedStatement.setInt(3, solicitud.getAdmin().getIdAdmin());
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            preparedStatement.setString(4, solicitud.getFechaSolicitud().toString());
            preparedStatement.setString(5, solicitud.getEstado().toDb());
            preparedStatement.setString(6, solicitud.getComentariosCliente());
            preparedStatement.setString(7, solicitud.getNotasInternas());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Solicitud solicitud) {
        String query = String.format(
                "UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
                SchemaDB.T_SOLICITUDES,
                SchemaDB.C_ID_CLIENTE, SchemaDB.C_ID_PLAN, SchemaDB.C_ID_ADMIN,
                SchemaDB.C_FECHA_SOLICITUD, SchemaDB.C_ESTADO,
                SchemaDB.C_COMENTARIOS_CLIENTE, SchemaDB.C_NOTAS_INTERNAS,
                SchemaDB.C_ID_SOLICITUD);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, solicitud.getCliente().getIdCliente());
            preparedStatement.setInt(2, solicitud.getPlan().getIdPlan());
            if (solicitud.getAdmin() != null) {
                preparedStatement.setInt(3, solicitud.getAdmin().getIdAdmin());
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            preparedStatement.setString(4, solicitud.getFechaSolicitud().toString());
            preparedStatement.setString(5, solicitud.getEstado().toDb());
            preparedStatement.setString(6, solicitud.getComentariosCliente());
            preparedStatement.setString(7, solicitud.getNotasInternas());
            preparedStatement.setInt(8, solicitud.getIdSolicitud());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteById(int idSolicitud) {
        String query = String.format("DELETE FROM %s WHERE %s = ?",
                SchemaDB.T_SOLICITUDES, SchemaDB.C_ID_SOLICITUD);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idSolicitud);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la SQL: " + e.getMessage());
            return false;
        }
    }

    private SolicitudResumen mapResultSetToResumen(ResultSet rs) throws SQLException {
        return new SolicitudResumen(
                rs.getInt(SchemaDB.C_ID_SOLICITUD),
                rs.getString("nombre_cliente"),
                rs.getString(SchemaDB.C_APELLIDOS_CLIENTE),
                rs.getString("nombre_plan"),
                rs.getDate(SchemaDB.C_FECHA_SOLICITUD).toLocalDate(),
                Estado.fromDb(rs.getString(SchemaDB.C_ESTADO))
        );
    }
}