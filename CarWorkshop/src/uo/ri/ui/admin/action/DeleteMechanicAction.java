package uo.ri.ui.admin.action;

import uo.ri.bussness.AdminService;
import uo.ri.bussness.impl.AdminServiceImpl;
import uo.ri.bussness.impl.admin.DeleteMechanic;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.conf.ServicesFactory;

public class DeleteMechanicAction implements Action {

	
	@Override
	public void execute() throws BusinessException {
		
		Long idMecanico = Console.readLong("Id de mecánico");

		AdminService as = ServicesFactory.getAdminService();
		as.deleteMechanic(idMecanico);
		
		Console.println("Se ha eliminado el mecánico");
	}

}
