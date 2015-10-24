package uo.ri.amp.conf;

import uo.ri.amp.bussness.AdminService;
import uo.ri.amp.bussness.impl.AdminServiceImpl;

/**
 * Created by Jorge.
 */
public class ServiceFactory {

    static public AdminService getAdminService(){
        return new AdminServiceImpl();
    }
}
