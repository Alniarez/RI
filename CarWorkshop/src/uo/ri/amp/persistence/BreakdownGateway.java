package uo.ri.amp.persistence;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public interface BreakdownGateway {

    public void setConnection(Connection connection);

    public void addBreakdown(Averia averia);

    boolean exists(Averia averia);

    void assgnBreakdown(Averia averia);

    void updateBreakdown(Averia averia);

    List<Map<String,Object>> listBreakdownHistory(Vehiculo vehiculo);

    List<Map<String,Object>> listCompetentMechanics(Averia averia);

    boolean existsVehicle(Vehiculo vehiculo);
}
