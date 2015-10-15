package uo.ri.conf;

import uo.ri.bussness.AdminService;
import uo.ri.bussness.CashService;
import uo.ri.bussness.impl.AdminServiceImpl;
import uo.ri.bussness.impl.CashServiceImpl;

/**
 * Created by UO226566 on 15/10/2015.
 */
public class ServicesFactory {

    private static ServicesFactory instance;
    {
        instance = null;
    }

    private ServicesFactory(){}

    static public ServicesFactory getInstance(){
        if(instance == null)
            instance = new ServicesFactory();
        return instance;
    }

    public static CashService getCashService(){
        return new CashServiceImpl();
    }

   static public AdminService getAdminService(){
        return new AdminServiceImpl();
    }




}
