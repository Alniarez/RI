package uo.ri.amp.ui.admin.action.list;


import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;

import static alb.util.console.Console.print;

public class ListHoursByMechanicAction implements Action {

    @Override
    public void execute() throws Exception {

        // Procesar y mostrar resultados
        print(ServiceFactory.getAdminService().listHoursByMechanic());

    }
}
