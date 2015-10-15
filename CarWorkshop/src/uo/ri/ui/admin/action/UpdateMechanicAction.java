package uo.ri.ui.admin.action;

import uo.ri.bussness.AdminService;
import uo.ri.bussness.impl.AdminServiceImpl;
import uo.ri.bussness.impl.admin.UpdateMechanic;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.conf.ServicesFactory;

public class UpdateMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		
		// Pedir datos
		Long id = Console.readLong("Id del mecánico"); 
		String nombre = Console.readString("Nombre"); 
		String apellidos = Console.readString("Apellidos");
		
		// Procesar
		AdminService as = ServicesFactory.getAdminService();
		as.updateMechanic(id,nombre,apellidos);
		
		// Mostrar resultado
		Console.println("Mecánico actualizado");
	}

}
