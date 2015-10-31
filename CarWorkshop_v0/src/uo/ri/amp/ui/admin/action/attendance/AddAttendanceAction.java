package uo.ri.amp.ui.admin.action.attendance;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.common.BusinessException;

import java.util.Date;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;
/**
 * Created by Jorge.
 */
public class AddAttendanceAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = leerCadena("Código del curso");
        long codigoMecanico = leerLong("Código del mecnánico");
        Date dateIn = leerFecha("Fecha de comienzo (DD/MM/YYYY)");
        Date dateOut = leerFecha("Fecha de finalización (DD/MM/YYYY)");
        int porcentajeAsistencia = leerEntero("Porcentaje de asistencia");
        String apto = leerCadena("¿Resultada apto? (s/n)");

        // Generar modelo
        Asistencia asistencia = new Asistencia();
        asistencia.setIdMecanico(codigoMecanico);
        asistencia.setIdCurso(codigoCurso);
        asistencia.setFechaComienzo(dateIn);
        asistencia.setFechaFin(dateOut);
        asistencia.setApto(apto.equalsIgnoreCase("s"));
        asistencia.setPorcentajeAsistencia(porcentajeAsistencia);

        // Procesar
        ServiceFactory.getAdminService().addAttendance(asistencia);

        // Mostrar resultado
        println("Se ha añadido la asistencia.");
    }


}