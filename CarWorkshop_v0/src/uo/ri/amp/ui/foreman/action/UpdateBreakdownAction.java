package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import java.util.Date;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;

/**
 * Created by Jorge.
 */
public class UpdateBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        String descripcion = leerCadena("Descripción de la avería");
        Date fecha = leerFecha("Fecha de entrada (dd/mm/yyyy)");

               // Generar modelo
        Averia averia = new Averia();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMacricula(matricula);
        averia.setVehiculo(vehiculo);
        averia.setDescripcion(descripcion);
        averia.setFecha(fecha);
        averia.setStatus(Averia.AveriaStatus.ABIERTA);

        //Procesar
        ServiceFactory.getForemanService().updateBreakdown(averia);

        //Mostrar resultado
        println("Se ha modificado la avería correctamente.");
    }

}