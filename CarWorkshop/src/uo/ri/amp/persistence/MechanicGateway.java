package uo.ri.amp.persistence;

import uo.ri.amp.model.Mecanico;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface MechanicGateway {

    public boolean exists(Mecanico mecanico);

    void setConnection(Connection connection);
}
