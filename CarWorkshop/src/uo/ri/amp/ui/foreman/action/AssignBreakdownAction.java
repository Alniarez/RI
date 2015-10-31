package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
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
public class AssignBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = readString("Matricula del coche");
        String fecha = readString("Fecha de entrada (dd/mm/yyyy)");

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMacricula(matricula);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEntrada = null;
        try {
            fechaEntrada = sdf.parse(fecha);
        } catch (ParseException e) {
            throw new BusinessException("Error en el formato de la fecha.", e);
        }

        if(readString("¿Desea ver la lista de mecánicos? (y/n)").equalsIgnoreCase("y"))
            System.out.println(ServiceFactory.getForemanService().listCompetentMechanics(vehiculo));

        long idMecanico = readLong("ID de mecánico.");

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
        println("Se ha eliminado la avería correctamente.");
    }
}