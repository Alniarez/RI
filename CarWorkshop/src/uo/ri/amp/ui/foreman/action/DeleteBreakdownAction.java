package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Averia;

import static alb.util.console.Console.println;
import static alb.util.console.Console.readLong;

/**
 * Created by Jorge.
 */
public class DeleteBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        long id = readLong("ID de la avería.");

        // Generar modelo
        Averia averia = new Averia();
        averia.setId(id);

        //Procesar
        ServiceFactory.getForemanService().removeBreakdown(averia);

        //Mostrar resultado
        println("Se ha eliminado la avería correctamente.");
    }
}