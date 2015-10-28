package uo.ri.amp.persistence.impl;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.BreakdownGateway;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public class BreakdownGatewayImpl implements BreakdownGateway {
    @Override
    public void setConnection(Connection connection) {

    }

    @Override
    public void addBreakdown(Averia averia) {

    }

    @Override
    public boolean exists(Averia averia) {
        return false;
    }

    @Override
    public void assgnBreakdown(Averia averia) {

    }

    @Override
    public void updateBreakdown(Averia averia) {

    }

    @Override
    public List<Map<String, Object>> listBreakdownHistory(Vehiculo vehiculo) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listCompetentMechanics(Averia averia) {
        return null;
    }

    @Override
    public boolean existsVehicle(Vehiculo vehiculo) {
        return false;
    }
}
