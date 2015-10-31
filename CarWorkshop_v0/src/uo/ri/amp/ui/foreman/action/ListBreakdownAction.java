package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Vehiculo;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;

/**
 * Created by Jorge.
 */
public class ListBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMacricula(leerCadena("Matriula del vehículo"));

        // Procesar y mostrar resultados
        println(ServiceFactory.getForemanService().listBreakdownHistory(vehiculo));

    }
}
