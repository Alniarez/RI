package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.VehicleGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class VehicleGatewayImpl implements VehicleGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean existsType(TipoVehiculo tipoVehiculo) throws BusinessException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("vehiculo_select_exists"));
            ps.setLong(1, tipoVehiculo.getId());
            rs = ps.executeQuery();
            while(rs.next())
                return true;

            return false;
        } catch (SQLException e) {
            throw new BusinessException("Se prodijo un error en la base de datos.",e);
        } finally {
            Jdbc.close(rs, ps);
        }
    }

}
