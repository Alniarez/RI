package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.BreakdownGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public class BreakdownGatewayImpl implements BreakdownGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addBreakdown(Averia averia) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("averia_add"));
            ps.setString(1,averia.getDescripcion());
            ps.setDate(2, new java.sql.Date(averia.getFecha().getTime()));
            ps.setString(3, "ABIERTA");
            ps.setLong(4, averia.getVehiculo().getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public boolean exists(Averia averia) throws BusinessException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Conf.get("averia_select"));
            ps.setLong(1, averia.getVehiculo().getId());
            ps.setDate(2, new java.sql.Date(averia.getFecha().getTime()));
            rs = ps.executeQuery();
            while(rs.next())
                return true;
            return false;
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, ps);
        }
    }

    @Override
    public void assgnBreakdown(Averia averia) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("averia_asignar"));
            ps.setLong(1, averia.getMecanico().getId());
            ps.setString(2, "ASIGNADA");
            ps.setLong(3, averia.getVehiculo().getId());
            ps.setDate(4, new java.sql.Date(averia.getFecha().getTime()));
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public void updateBreakdown(Averia averia) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("averia_update"));
            ps.setString(1, averia.getDescripcion());
            ps.setDate(2, new java.sql.Date(averia.getFecha().getTime()));
            ps.setLong(3, averia.getVehiculo().getId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public void removeBreakdown(Averia averia) throws BusinessException {
        //TODO
    }

    @Override
    public List<Map<String, Object>> listBreakdownHistory(Vehiculo vehiculo) {
        //TODO
        return null;
    }




}
