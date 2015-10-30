package uo.ri.amp.ui.admin.action.grade;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

import static alb.util.console.Console.*;


public class DeleteGradeAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = readString("Código de curso");

        //Generar modelo
        Curso curso = new Curso();
        curso.setCodigo(codigo);

        // Procesar
        ServiceFactory.getAdminService().deleteGrade(curso);

        // Mostrar resultado
        println("Se ha eliminado el curso.");
    }
}