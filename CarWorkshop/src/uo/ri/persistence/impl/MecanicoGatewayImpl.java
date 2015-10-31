package uo.ri.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.common.BusinessException;
import uo.ri.persistence.MecanicoGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by UO226566 on 15/10/2015.
 */
public class MecanicoGatewayImpl implements MecanicoGateway{

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return null;
    }

    @Override
    public void update(Long id, String nombre, String apellidos) {

    }

    @Override
    public void save(String nombre, String apellidos) throws BusinessException {
        String SQL = "insert into TMecanicos(nombre, apellidos) values (?, ?)";

        PreparedStatement pst = null;

        try {
            pst = connection.prepareStatement(SQL);

            pst.setString(1, nombre);
            pst.setString(2, apellidos);

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new BusinessException(e);
        }finally {
            Jdbc.close(pst);
        }
    }

    @Override
    public void delete(Long id) {

    }
}
