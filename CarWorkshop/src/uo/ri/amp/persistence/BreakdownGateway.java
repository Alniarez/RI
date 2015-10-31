package uo.ri.amp.persistence;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public interface BreakdownGateway {

    public void setConnection(Connection connection);

    public void addBreakdown(Averia averia) throws BusinessException;

    void removeBreakdown(Averia averia) throws BusinessException;

    boolean exists(Averia averia) throws BusinessException;

    void assgnBreakdown(Averia averia) throws BusinessException;

    void updateBreakdown(Averia averia) throws BusinessException;

    List<Map<String,Object>> listBreakdownHistory(Vehiculo vehiculo) throws BusinessException;


}
