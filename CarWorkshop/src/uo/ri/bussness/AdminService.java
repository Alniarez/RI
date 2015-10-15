package uo.ri.bussness;

import uo.ri.common.BusinessException;

import java.util.List;
import java.util.Map;

public interface AdminService {
	
	public void addMechanic(String nombre, String apellidos) throws BusinessException;
	public List<Map<String, Object>> listMechanic()throws BusinessException;
	public void updateMechanic(Long id, String nombre, String apellidos)throws BusinessException;
	public void deleteMechanic(Long id)throws BusinessException;

}
