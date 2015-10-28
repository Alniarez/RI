package uo.ri.amp.ui.admin.action.attendance;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.common.BusinessException;

import static alb.util.console.Console.*;

/**
 * Created by Jorge.
 */
public class DeleteAttendanceAction implements Action {
    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = readString("Código del curso");
        long codigoMecanico = readLong("Código del mecnánico");

        // Generar modelo
        Asistencia asistencia = new Asistencia();
        asistencia.setIdCurso(codigoCurso);
        asistencia.setIdMecanico(codigoMecanico);

        // Procesar
        ServiceFactory.getAdminService().deleteAttendance(asistencia);

        // Mostrar resultados
        println("Asistencia eliminada con éxito.");

    }
}