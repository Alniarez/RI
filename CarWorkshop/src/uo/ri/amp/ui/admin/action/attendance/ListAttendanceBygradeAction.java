package uo.ri.amp.ui.admin.action.attendance;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Curso;

import static alb.util.console.Console.print;
import static alb.util.console.Console.readString;

/**
 * Created by Jorge.
 */
public class ListAttendanceBygradeAction implements Action {
    @Override
    public void execute() throws Exception {

        // Pedir datos
        String codigoCurso = readString("Código del curso");

        // Generar modelo
        Curso curso = new Curso();
        curso.setCodigo(codigoCurso);

        // Procesar y mostrar resultados
        print(ServiceFactory.getAdminService().listAttendance(curso));

    }
}