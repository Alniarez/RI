package uo.ri.bussness;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

public interface CashService {
	
	public List<Map<String, Object>> facturarRepareciones(List<Long> idsAveria) throws BusinessException;


}
