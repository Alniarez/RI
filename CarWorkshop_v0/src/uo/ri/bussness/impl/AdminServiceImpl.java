package uo.ri.bussness.impl;

import uo.ri.bussness.AdminService;
import uo.ri.bussness.impl.admin.AddMechanic;
import uo.ri.bussness.impl.admin.DeleteMechanic;
import uo.ri.bussness.impl.admin.ListMechanics;
import uo.ri.bussness.impl.admin.UpdateMechanic;
import uo.ri.common.BusinessException;

import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService{

	@Override
	public void addMechanic(String nombre, String apellidos)
			throws BusinessException {
		new AddMechanic(nombre,apellidos).execute();
		
	}

	@Override
	public List<Map<String, Object>> listMechanic() throws BusinessException {
		ListMechanics l = new ListMechanics();
		l.execute();
		return l.getResult();
		
	}

	@Override
	public void updateMechanic(Long id, String nombre, String apellidos)
			throws BusinessException {
        new UpdateMechanic(id, nombre, apellidos).execute();
		
	}

	@Override
	public void deleteMechanic(Long id) throws BusinessException {
		new DeleteMechanic(id).execute();
		
	}

}
