package uo.ri.amp.ui.admin.action.grade;


import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.Curso;

import static alb.util.console.Console.print;
import static alb.util.console.Console.readLong;

public class ListGradesAction implements Action{

    @Override
    public void execute() throws Exception {

        // Procesar y mostrar resultados
        print(ServiceFactory.getAdminService().listGrades());

    }
}
