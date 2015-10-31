package uo.ri.amp.ui.admin.action.certificate;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.common.BusinessException;

import static alb.util.console.Console.println;

/**
 * Created by Jorge.
 */
public class GenerateCertificatesAction implements Action{

    @Override
    public void execute() throws BusinessException {

        // Procesar
        ServiceFactory.getAdminService().generateCertificates();

        //Mostrar resultados

        println("Proceso de generación de certificados finalizado.");


    }
}
