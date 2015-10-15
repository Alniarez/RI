package uo.ri.conf;

import uo.ri.persistence.FacturasGateway;
import uo.ri.persistence.MecanicoGateway;
import uo.ri.persistence.impl.FacturasGatewayImpl;
import uo.ri.persistence.impl.MecanicoGatewayImpl;

/**
 * Created by UO226566 on 15/10/2015.
 */
public class PersistenceFactory {

    private static PersistenceFactory instance;
    {
        instance = null;
    }

    private PersistenceFactory(){}

    static public PersistenceFactory getInstance(){
        if(instance == null)
            instance = new PersistenceFactory();
        return instance;
    }

    public static MecanicoGateway getMecanicoGateway(){
        return new MecanicoGatewayImpl();
    }

    static public FacturasGateway getFacturasGateway(){
        return new FacturasGatewayImpl();
    }

}
