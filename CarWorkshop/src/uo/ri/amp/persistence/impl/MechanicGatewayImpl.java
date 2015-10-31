package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.MechanicGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class MechanicGatewayImpl implements MechanicGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean exists(Mecanico mecanico) throws BusinessException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("mecanico_select_exists"));
            ps.setLong(1, mecanico.getId());
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
