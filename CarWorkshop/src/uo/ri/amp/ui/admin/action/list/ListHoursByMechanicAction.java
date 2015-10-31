package uo.ri.amp.ui.admin.action.list;


import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Mecanico;

import static alb.util.console.Console.print;
import static alb.util.console.Console.readLong;

public class ListHoursByMechanicAction implements Action {

    @Override
    public void execute() throws Exception {

        long idMecanico = readLong("ID de mecánico");

        Mecanico mecanico = new Mecanico();
        mecanico.setId(idMecanico);

        // Procesar y mostrar resultados
        print(ServiceFactory.getAdminService().listHoursByMechanic(mecanico));

    }
}
