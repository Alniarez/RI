package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;

/**
 * Created by Jorge.
 */
public class GradeGatewayImpl implements GradeGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void addGrade(Curso curso) throws BusinessException {
        try {
            PreparedStatement ps;
            ps= connection.prepareStatement(Conf.get("curso_add"));
            ps.setString(1,curso.getCodigo());
            ps.setString(2,curso.getNombre());
            ps.setString(3,curso.getDescripcion());
            ps.setInt(4, curso.getHorasTotales());

            ps.execute();

            Jdbc.close(ps);
            ps= connection.prepareStatement(Conf.get("contenidoCurso_add"));

            for(ContenidoCurso cc : curso.getContenidoCurso()){
                ps.setString(1, curso.getCodigo());
                ps.setLong(2, cc.getSobre().getId());
                ps.setInt(3,cc.getPorcentaje());
                ps.execute();
            }

            Jdbc.close(ps);

            connection.commit();

        } catch (SQLException e) {
           throw new BusinessException("Se prodijo un error en la base de datos.",e);
        }

    }

    @Override
    public void deleteGrade(Curso curso) throws BusinessException {
        try {
            PreparedStatement ps = connection.prepareStatement(Conf.get("curso_delete"));

            ps.setString(1,curso.getCodigo());
            Jdbc.close(ps);
            connection.commit();

        } catch (SQLException e) {
            throw new BusinessException("Se prodijo un error en la base de datos.",e);
        }
    }

    @Override
    public void updateGrade(Curso curso) throws BusinessException {
        try {
            PreparedStatement ps;
            ps= connection.prepareStatement(Conf.get("curso_update"));
            ps.setString(1,curso.getCodigo());
            ps.setString(2,curso.getNombre());
            ps.setString(3,curso.getDescripcion());
            ps.setInt(4, curso.getHorasTotales());

            ps.execute();

            Jdbc.close(ps);
            ps= connection.prepareStatement(Conf.get("contenidoCurso_delete"));

            ps.setString(1, curso.getCodigo());
            ps.execute();

            Jdbc.close(ps);
            ps= connection.prepareStatement(Conf.get("contenidoCurso_add"));
            for(ContenidoCurso cc : curso.getContenidoCurso()){
                ps.setString(1, curso.getCodigo());
                ps.setLong(2, cc.getSobre().getId());
                ps.setInt(3,cc.getPorcentaje());
                ps.execute();
            }

            Jdbc.close(ps);
            connection.commit();

        } catch (SQLException e) {
            throw new BusinessException("Se prodijo un error en la base de datos.",e);
        }
    }

    @Override
    public List<Map<String, Object>> listGrades() throws BusinessException {
        List<Map<String, Object>> result = new LinkedList<>();

        return result;
    }

    @Override
    public List<Map<String, Object>> listHoursByType() throws BusinessException {
        return null;
    }

    @Override
    public List<Map<String, Object>> listHoursByMechanic(Mecanico mecanico) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listExpertsWithoutCertificate() {
        return null;
    }

    @Override
    public boolean exists(Curso curso) throws BusinessException {
        try {
            PreparedStatement ps = connection.prepareStatement(Conf.get("curso_exists"));
            ps.setString(1, curso.getCodigo());
            ResultSet rs = ps.executeQuery();

            int rowCount = rs.last() ? rs.getRow() : 0;

            Jdbc.close(rs, ps);

            return rowCount !=0;

        } catch (SQLException e) {
            throw new BusinessException("Se prodijo un error en la base de datos.",e);
        }
    }
}
