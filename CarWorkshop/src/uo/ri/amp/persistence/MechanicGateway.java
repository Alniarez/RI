package uo.ri.amp.persistence;

import uo.ri.amp.model.Mecanico;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface MechanicGateway {

    public boolean exists(Mecanico mecanico) throws BusinessException;

    void setConnection(Connection connection);
}
