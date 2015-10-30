package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.*;
import java.util.*;

/**
 * Created by Jorge.
 */
public class GradeGatewayImpl implements GradeGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addGrade(Curso curso) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("curso_add"));
            ps.setString(1, curso.getCodigo());
            ps.setString(2, curso.getNombre());
            ps.setString(3, curso.getDescripcion());
            ps.setInt(4, curso.getHorasTotales());
            ps.execute();
            addContenidoCurso(curso);
            connection.commit();
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos. [Error " + e.getErrorCode(), e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public void deleteGrade(Curso curso) throws BusinessException {
        PreparedStatement ps = null;
        try {
            deleteContenidoCurso(curso);
            ps = connection.prepareStatement(Conf.get("curso_delete"));
            ps.setString(1, curso.getCodigo());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public void updateGrade(Curso curso) throws BusinessException {
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(Conf.get("curso_update"));
            ps.setString(4, curso.getCodigo());
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getHorasTotales());
            ps.execute();
            Jdbc.close(ps);
            deleteContenidoCurso(curso);
            addContenidoCurso(curso);
            Jdbc.close(ps);
            connection.commit();
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        }
    }

    @Override
    public List<Map<String, Object>> listGrades() throws BusinessException {
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(Conf.get("curso_select_all"));
            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("codigo", rs.getString(1));
                map.put("nombre", rs.getString(2));
                map.put("descripcion", rs.getString(3));
                map.put("horastotales", rs.getInt(4));
                result.add(map);
            }
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, st);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> listHoursByType() throws BusinessException {
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(Conf.get("curso_select_horas_por_tipo_mecanicos"));
            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("idTiposHeviculo", rs.getInt(1));
                map.put("nombreTiposHeviculo", rs.getString(2));
                map.put("idMecaico", rs.getInt(3));
                map.put("nombre", rs.getString(4));
                map.put("apellidos", rs.getString(5));
                map.put("horas", rs.getInt(6));
                result.add(map);
            }
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, st);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> listHoursByMechanic(Mecanico mecanico) {
        Long id = mecanico.getId();
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Conf.get("curso_select_horas_tipo_mecanico_A"));
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("horasCursadas", rs.getInt(1));
                map.put("horasTotales", rs.getInt(2));
                result.add(map);
            }
            Jdbc.close(rs, ps);
            ps = connection.prepareStatement(Conf.get("curso_select_horas_tipo_mecanico_B"));
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("tipo", rs.getString(2));
                map.put("horas", rs.getInt(3));
                result.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.close(rs, ps);
        }
        return null;
    }

    @Override
    public boolean exists(Curso curso) throws BusinessException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("curso_select_exists"));
            ps.setString(1, curso.getCodigo());
            rs = ps.executeQuery();
            while (rs.next())
                return true;
            return false;
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, ps);
        }
    }

    private void addContenidoCurso(Curso curso) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("contenidoCurso_add"));
            for (ContenidoCurso cc : curso.getContenidoCurso()) {
                ps.setString(1, curso.getCodigo());
                ps.setLong(2, cc.getSobre().getId());
                ps.setInt(3, cc.getPorcentaje());
                ps.execute();
            }
        } finally {
            Jdbc.close(ps);
        }
    }

    private void deleteContenidoCurso(Curso curso) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("contenidoCurso_delete"));
            ps.setString(1, curso.getCodigo());
            ps.execute();
        } finally {
            Jdbc.close(ps);
        }
    }
}
