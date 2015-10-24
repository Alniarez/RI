package uo.ri.amp.ui;

import alb.util.menu.BaseMenu;

/**
 * Created by Jorge.
 */
public class MainMenu extends BaseMenu {

    public MainMenu() {
        menuOptions = new Object[][] {
                { "Taller", null },
                { "Administrador",      uo.ri.amp.ui.admin.MainMenu.class },
                { "Jefe de taller", 	uo.ri.amp.ui.foreman.MainMenu.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
