package uo.ri.amp.bussiness;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface ForemanService {
    public void addBreakdown(Averia averia) throws BusinessException;
    public void updateBreakdown(Averia averia) throws BusinessException;

    public void assignBreakdown(Averia averia) throws BusinessException;
    public String listCompetentMechanics(Averia vehiculo) throws BusinessException;

    public String listBreakdownHistory(Vehiculo vehiculo) throws BusinessException;
}
