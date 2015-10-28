package uo.ri.amp.persistence.impl;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.MechanicGateway;

import java.sql.Connection;

/**
 * Created by Jorge.
 */


public class MechanicGatewayImpl implements MechanicGateway {

    private Connection connection;

    @Override
    public boolean exists(Mecanico mecanico) {
        return false;
    }



    @Override
    public void setConnection(Connection connection) {

    }
}
