package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.grade.AddGradeAction;
import uo.ri.amp.ui.admin.action.grade.DeleteGradeAction;
import uo.ri.amp.ui.admin.action.grade.ListGradesAction;
import uo.ri.amp.ui.admin.action.grade.UpdateGradeAction;

public class GradeMenu extends BaseMenu {

    public GradeMenu() {
        menuOptions = new Object[][] {
                { "Administrador > Gestión de cursos", null },
                { "Añadir curso", 				    AddGradeAction.class },
                { "Modificar datos de cursos", 	    UpdateGradeAction.class },
                { "Eliminar curso", 				DeleteGradeAction.class },
                { "Listar cursos", 				    ListGradesAction.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
