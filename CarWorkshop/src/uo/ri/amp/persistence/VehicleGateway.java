package uo.ri.amp.persistence;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface VehicleGateway {

    public boolean exists(Vehiculo vehiculo) throws BusinessException;

    public boolean existsType(TipoVehiculo tipoVehiculo) throws BusinessException;

    public Long getId(Vehiculo vehiculo) throws BusinessException;

    void setConnection(Connection connection);
}
