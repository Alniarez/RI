package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Vehiculo;

import static alb.util.console.Console.print;
import static alb.util.console.Console.readString;

/**
 * Created by Jorge.
 */
public class ListBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMacricula(readString("Matriula del vehículo"));

        // Procesar y mostrar resultados
        print(ServiceFactory.getForemanService().listBreakdownHistory(vehiculo));

    }
}
