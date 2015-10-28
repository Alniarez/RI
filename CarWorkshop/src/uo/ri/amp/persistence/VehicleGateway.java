package uo.ri.amp.persistence;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.Vehiculo;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface VehicleGateway {

    public boolean exists(Vehiculo vehiculo);
    public boolean existsType(TipoVehiculo tipoVehiculo);

    void setConnection(Connection connection);
}
