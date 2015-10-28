package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;

import static alb.util.console.Console.println;
import static alb.util.console.Console.readLong;
import static alb.util.console.Console.readString;

/**
 * Created by Jorge.
 */
public class AssignBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        long idAveria = readLong("ID de la avería.");
        Averia averia = new Averia();
        averia.setId(idAveria);

        if(readString("¿Desea ver la lista de mecánicos? (y/n)").equalsIgnoreCase("y"))
            ServiceFactory.getForemanService().listCompetentMechanics(averia);

        long idMecanico = readLong("ID de mecánico.");

        // Generar modelo
        Mecanico mecanico = new Mecanico();
        mecanico.setId(idMecanico);

        //Procesar
        ServiceFactory.getForemanService().assignBreakdown(averia);

        //Mostrar resultado
        println("Se ha eliminado la avería correctamente.");
    }
}