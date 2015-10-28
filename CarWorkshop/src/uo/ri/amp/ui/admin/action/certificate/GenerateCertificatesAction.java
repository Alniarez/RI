package uo.ri.amp.ui.admin.action.certificate;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.common.BusinessException;

import static alb.util.console.Console.*;

/**
 * Created by Jorge.
 */
public class GenerateCertificatesAction implements Action{

    @Override
    public void execute() throws BusinessException {

        // Procesar
        ServiceFactory.getAdminService().generateCertificates();

        //Mostrar resultados

        print("Proceso de generación de certificados finalizado.");


    }
}
