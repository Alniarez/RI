package uo.ri.ui.admin.action;

import uo.ri.bussness.AdminService;
import uo.ri.bussness.impl.AdminServiceImpl;
import uo.ri.bussness.impl.admin.AddMechanic;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.conf.ServicesFactory;

public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		
		// Pedir datos
		String nombre = Console.readString("Nombre"); 
		String apellidos = Console.readString("Apellidos");
		
		// Procesar

		AdminService as = ServicesFactory.getAdminService();
		as.addMechanic(nombre, apellidos);
		
		
		// Mostrar resultado
		Console.println("Nuevo mecánico añadido");
	}

}
