package uo.ri.amp.persistence;

import uo.ri.amp.model.Mecanico;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface MechanicGateway {

    void setConnection(Connection connection);

    /**
     * Comprueba si existe un mecanico determinado.
     * @param mecanico a comprobar. Debe contener el campo Id.
     * @return
     * @throws BusinessException
     */
    public boolean exists(Mecanico mecanico) throws BusinessException;
}
