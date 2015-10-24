package uo.ri.amp.ui.admin.action.grade;


import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.common.BusinessException;

import java.util.LinkedList;
import java.util.List;

public class DeleteGradeAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        Long codigo = Console.readLong("Código de curso");

        //Generar modelo
        Curso curso = new Curso();
        curso.setId(codigo);


        // Procesar
        ServiceFactory.getAdminService().removeGrade(curso);


        // Mostrar resultado
        Console.println("Se ha eliminado el curso.");
    }
}