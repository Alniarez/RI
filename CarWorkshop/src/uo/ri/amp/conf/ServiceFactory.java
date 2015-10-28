package uo.ri.amp.conf;

import uo.ri.amp.bussiness.AdminService;
import uo.ri.amp.bussiness.impl.AdminServiceImpl;
import uo.ri.amp.bussiness.impl.ForemanServiceImpl;

/**
 * Created by Jorge.
 */
public class ServiceFactory {

    static public AdminService getAdminService(){
        return new AdminServiceImpl();
    }

    public static ForemanServiceImpl getForemanService() {
        return new ForemanServiceImpl();
    }
}
