package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

    public MainMenu() {
        menuOptions = new Object[][] {
                { "Administrador", null },
                { "Gestión de cursos", 			    GradeMenu.class },
                { "Gestión de asistencia",          AttendanceMenu.class},
                { "Gestión de certificados", 		CertificateMenu.class },
                { "Listados",               	    ListMenu.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
