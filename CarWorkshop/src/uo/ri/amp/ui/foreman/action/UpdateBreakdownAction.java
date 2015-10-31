package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static alb.util.console.Console.println;
import static alb.util.console.Console.readLong;
import static alb.util.console.Console.readString;

/**
 * Created by Jorge.
 */
public class UpdateBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = readString("Matricula del coche");
        String descripcion = readString("Descripción de la avería");
        String fecha = readString("Fecha de entrada (dd/mm/yyyy)");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEntrada = null;
        try {
            fechaEntrada = sdf.parse(fecha);
        } catch (ParseException e) {
            throw new BusinessException("Error en el formato de la fecha.", e);
        }

        // Generar modelo
        Averia averia = new Averia();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMacricula(matricula);
        averia.setVehiculo(vehiculo);
        averia.setDescripcion(descripcion);
        averia.setFecha(fechaEntrada);
        averia.setStatus(Averia.AveriaStatus.ABIERTA);

        //Procesar
        ServiceFactory.getForemanService().updateBreakdown(averia);

        //Mostrar resultado
        println("Se ha modificado la avería correctamente.");
    }

}