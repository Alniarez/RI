package uo.ri.amp.ui.admin.action.list;


import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Mecanico;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;

public class ListHoursByMechanicAction implements Action {

    @Override
    public void execute() throws Exception {

        long idMecanico = leerEntero("ID de mecánico");

        Mecanico mecanico = new Mecanico();
        mecanico.setId(idMecanico);

        // Procesar y mostrar resultados
        println(ServiceFactory.getAdminService().listHoursByMechanic(mecanico));

    }
}
