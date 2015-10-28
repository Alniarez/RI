package uo.ri.amp.ui.admin.action.attendance;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.common.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static alb.util.console.Console.*;

/**
 * Created by Jorge.
 */
public class UpdateAttendanceAction implements Action {
    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = readString("Código del curso");
        long codigoMecanico = readLong("Código del mecnánico");
        String fechaIn = readString("Fecha de comienzo (DD/MM/YYYY)");
        String fechaOut = readString("Fecha de finalización (DD/MM/YYYY)");
        int porcentajeAsistencia = readInt("Porcentaje de asistencia");
        String apto = readString("Resultada apto? (s/n)");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        Date dateIn = null;
        Date dateOut = null;
        try {
            dateIn = sdf.parse(fechaIn);
            dateOut = sdf.parse(fechaOut);
        } catch (ParseException e) {
            throw new BusinessException("Error en el formato de la fecha.", e);
        }

        // Generar modelo
        Asistencia asistencia = new Asistencia();
        asistencia.setIdMecanico(codigoMecanico);
        asistencia.setIdCurso(codigoCurso);
        asistencia.setFechaComienzo(dateIn);
        asistencia.setFechaFin(dateOut);
        asistencia.setApto(apto.equalsIgnoreCase("s"));

        // Procesar
        ServiceFactory.getAdminService().updateAttendance(asistencia);

        // Mostrar resultado
        println("Asistencia modificada.");
    }
}