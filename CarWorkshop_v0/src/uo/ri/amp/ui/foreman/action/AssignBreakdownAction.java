package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Vehiculo;
import java.util.Date;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;

/**
 * Created by Jorge.
 */
public class AssignBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        Date fechaEntrada = leerFecha("Fecha de entrada (dd/mm/yyyy)");

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMacricula(matricula);


        if(leerCadena("¿Desea ver la lista de mecánicos? (y/n)").equalsIgnoreCase("y"))
            System.out.println(ServiceFactory.getForemanService().listCompetentMechanics(vehiculo));

        long idMecanico = leerLong("ID de mecánico");

        // Generar modelo
        Mecanico mecanico = new Mecanico();
        mecanico.setId(idMecanico);

        Averia averia = new Averia();

        averia.setMecanico(mecanico);
        averia.setFecha(fechaEntrada);
        averia.setVehiculo(vehiculo);

        //Procesar
        ServiceFactory.getForemanService().assignBreakdown(averia);

        //Mostrar resultado
        println("Se ha asignado la avería correctamente.");
    }
}