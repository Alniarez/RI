package uo.ri.amp.persistence.impl;

import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.VehicleGateway;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public class VehicleGatewayImpl implements VehicleGateway {


    @Override
    public boolean exists(Vehiculo vehiculo) {
        return false;
    }

    @Override
    public boolean existsType(TipoVehiculo tipoVehiculo) {
        return false;
    }

    @Override
    public void setConnection(Connection connection) {

    }
}
