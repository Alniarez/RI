package uo.ri.amp.bussiness;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface ForemanService {

    void addBreakdown(Averia averia) throws BusinessException;

    void updateBreakdown(Averia averia) throws BusinessException;

    void assignBreakdown(Averia averia) throws BusinessException;

    String listCompetentMechanics(Vehiculo vehiculo) throws BusinessException;

    String listBreakdownHistory(Vehiculo vehiculo) throws BusinessException;

    void removeBreakdown(Averia averia) throws BusinessException;
}
