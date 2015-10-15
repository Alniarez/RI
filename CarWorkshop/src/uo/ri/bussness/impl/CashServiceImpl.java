package uo.ri.bussness.impl;

import java.util.List;
import java.util.Map;

import uo.ri.bussness.CashService;
import uo.ri.bussness.impl.cash.FacturarReparaciones;
import uo.ri.common.BusinessException;

public class CashServiceImpl implements CashService{

	@Override
	public List<Map<String, Object>> facturarRepareciones(List<Long> idsAveria) throws BusinessException {
		FacturarReparaciones f = new FacturarReparaciones(idsAveria);
		f.execute();
		return f.getResult();		
	}

}
