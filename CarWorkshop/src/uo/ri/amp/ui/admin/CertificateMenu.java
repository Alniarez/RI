package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.certificate.GenerateCertificatesAction;

public class CertificateMenu  extends BaseMenu {

    public CertificateMenu() {
        menuOptions = new Object[][] {
                { "Administrador > Gestión de certificados", null },
                { "Generar certificados", 	        GenerateCertificatesAction.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
