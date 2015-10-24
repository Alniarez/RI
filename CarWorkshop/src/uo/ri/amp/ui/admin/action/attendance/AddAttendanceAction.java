package uo.ri.amp.ui.admin.action.attendance;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.common.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jorge.
 */
public class AddAttendanceAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        Long codigoCurso = Console.readLong("Código del curso");
        Long codigoMecanico = Console.readLong("Código del mecnánico");
        String fechaIn = Console.readString("Fecha de comienzo (DD/MM/YYYY)");
        String fechaOut = Console.readString("Fecha de finalización (DD/MM/YYYY)");
        int porcentajeAsistencia = Console.readInt("Porcentaje de asistencia");
        String apto = Console.readString("Resultada apto? (s/n)");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        Date dateIn = null;
        Date dateOut = null;
        try {
            dateIn = sdf.parse(fechaIn);
            dateOut = sdf.parse(fechaOut);
        } catch (ParseException e) {
            throw new BusinessException("Error en el formato de la fecha.", e);
        }

        //Generar modelo
        Asistencia asistencia = new Asistencia();
        asistencia.setIdMecanico(codigoMecanico);
        asistencia.setIdCurso(codigoCurso);
        asistencia.setFechaComienzo(dateIn);
        asistencia.setFechaFin(dateOut);
        asistencia.setApto(apto.equals("s"));
        if(asistencia.getPorcentajeAsistencia()<85 && asistencia.isApto())
            throw new BusinessException("Para ser apto se debe cumplir: [Porcentaje asistencia > 84].");


        // Procesar
        ServiceFactory.getAdminService().addAttendance(asistencia);


        // Mostrar resultado
        Console.println("Se ha añadido la asistencia.");
    }


}