package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.AttendanceGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public class AttendancegatewayImpl implements AttendanceGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addAttendance(Asistencia asistencia) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("asistencia_add"));
            ps.setString(1, asistencia.getIdCurso());
            ps.setLong(2, asistencia.getIdMecanico());
            ps.setDate(3, new java.sql.Date(asistencia.getFechaComienzo().getTime()));
            ps.setDate(4, new java.sql.Date(asistencia.getFechaFin().getTime()));
            ps.setInt(5, asistencia.getPorcentajeAsistencia());
            ps.setString(6, asistencia.isAptoString());
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos." + e.getErrorCode(), e);
        } finally {
            Jdbc.close(ps);
        }
    }


    @Override
    public void deleteAttendance(Asistencia asistencia) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("asistencia_delete"));
            ps.setString(1, asistencia.getIdCurso());
            ps.setLong(2, asistencia.getIdMecanico());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public void updateAttendance(Asistencia asistencia) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("asistencia_update"));
            ps.setDate(1, new java.sql.Date(asistencia.getFechaComienzo().getTime()));
            ps.setDate(2, new java.sql.Date(asistencia.getFechaFin().getTime()));
            ps.setInt(3, asistencia.getPorcentajeAsistencia());
            ps.setString(4, asistencia.isAptoString());
            ps.setString(5, asistencia.getIdCurso());
            ps.setLong(6, asistencia.getIdMecanico());
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos." + e.getErrorCode(), e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public List<Map<String, Object>> listAttendance(Curso curso) throws BusinessException {
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Conf.get("asistencia_select_all_curso"));
            ps.setString(1, curso.getCodigo());
            rs = ps.executeQuery();
            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("idCurso", rs.getString(1));
                map.put("idMecanico", rs.getLong(2));
                map.put("fechaIn", rs.getDate(3));
                map.put("fechaOut", rs.getDate(4));
                map.put("porcentaje", rs.getInt(5));
                map.put("apto", rs.getString(6));
                result.add(map);
            }
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, ps);
        }
        return result;
    }

    @Override
    public boolean exisists(Asistencia asistencia) throws BusinessException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("asistencia_select_exists"));
            ps.setString(1, asistencia.getIdCurso());
            ps.setLong(2, asistencia.getIdMecanico());
            rs = ps.executeQuery();
            while (rs.next())
                return true;
            return false;
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, ps);
        }
    }

    @Override
    public boolean exisistsAnyMechanic(Curso curso) throws BusinessException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("asistencia_select_exists_curso"));
            ps.setString(1, curso.getCodigo());
            rs = ps.executeQuery();
            while (rs.next())
                return true;
            return false;
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, ps);
        }
    }

    private void rollback() {
        if(connection==null)
            return;
        try {
            connection.rollback();
        } catch (SQLException ignored) {
        }
    }
}
