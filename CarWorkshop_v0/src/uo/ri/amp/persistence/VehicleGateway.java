package uo.ri.amp.persistence;

import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface VehicleGateway {

    void setConnection(Connection connection);

    /**
     * Comprueba si existe un vehículo determinado.
     * @param vehiculo debe contener el campo Id.
     * @return
     * @throws BusinessException
     */
    boolean exists(Vehiculo vehiculo) throws BusinessException;

    /**
     * Comprueba si existe un tipo de vehículo determinado.
     * @param tipoVehiculo debe contener el campo Id.
     * @return
     * @throws BusinessException
     */
    boolean existsType(TipoVehiculo tipoVehiculo) throws BusinessException;

    /**
     * Obtiene el ID de un vehículo a partir de su matrícula.
     * Si existe más de una matricula igual retorna el id más bajo.
     * @param vehiculo debe contener el campo matricula.
     * @return
     * @throws BusinessException
     */
    Long getId(Vehiculo vehiculo) throws BusinessException;
}
