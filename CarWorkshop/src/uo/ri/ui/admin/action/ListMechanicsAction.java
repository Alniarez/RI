package uo.ri.ui.admin.action;

import java.util.Map;

import uo.ri.bussness.AdminService;
import uo.ri.bussness.impl.AdminServiceImpl;
import uo.ri.bussness.impl.admin.ListMechanics;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.conf.ServicesFactory;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {

		Console.println("\nListado de mecánicos\n");

		AdminService as = ServicesFactory.getAdminService();

		for (Map<String, Object> m : as.listMechanic()) {
			Console.printf("\t%d %s %s\n", m.get("id"), m.get("nombre"), m.get("apellidos"));
		}

	}
}
