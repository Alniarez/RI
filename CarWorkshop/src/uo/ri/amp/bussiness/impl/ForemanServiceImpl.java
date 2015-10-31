package uo.ri.amp.bussiness.impl;

import uo.ri.amp.bussiness.ForemanService;
import uo.ri.amp.bussiness.impl.foreman.*;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public class ForemanServiceImpl implements ForemanService {

    @Override
    public void addBreakdown(Averia averia) throws BusinessException {
        AddBreakdown addBreakdown = new AddBreakdown(averia);
        addBreakdown.execute();
    }

    @Override
    public void updateBreakdown(Averia averia) throws BusinessException{
        UpdateBreakdown updateBreakdown = new UpdateBreakdown(averia);
        updateBreakdown.execute();
    }

    @Override
    public void assignBreakdown(Averia averia) throws BusinessException {
        AssignBreakdown assignBreakdown = new AssignBreakdown(averia);
        assignBreakdown.execute();
    }

    @Override
    public String listCompetentMechanics(Vehiculo vehiculo) throws BusinessException {
        ListCompetentMechanics listCompetentMechanics = new ListCompetentMechanics(vehiculo);
        listCompetentMechanics.execute();
        return listCompetentMechanics.getPrintableResult();
    }

    @Override
    public String listBreakdownHistory(Vehiculo vehiculo) throws BusinessException {
        ListBreakdownHistory listBreakdownHistory = new ListBreakdownHistory(vehiculo);
        listBreakdownHistory.execute();
        return listBreakdownHistory.getPrintableResult();
    }

    @Override
    public void removeBreakdown(Averia averia) throws BusinessException {
        RemoveBreakdown removeBreakdown = new RemoveBreakdown(averia);
        removeBreakdown.execute();
    }
}
