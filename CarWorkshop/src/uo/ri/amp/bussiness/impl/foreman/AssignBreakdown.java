package uo.ri.amp.bussiness.impl.foreman;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.BreakdownGateway;
import uo.ri.amp.persistence.MechanicGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class AssignBreakdown {
    public AssignBreakdown(Averia averia) {
        this.averia = averia;
    }
    private final Averia averia;


    public void execute() throws BusinessException{
        BreakdownGateway breakdownGateway = PersistenceFactory.getBreakdownGateway();
        MechanicGateway mechanicGateway = PersistenceFactory.getMechanicGateway();

        Connection connection = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);

            mechanicGateway.setConnection(connection);
            breakdownGateway.setConnection(connection);

            if(!breakdownGateway.exists(averia))
                 throw new BusinessException("No existe la avería.");

            Mecanico mecanico = averia.getMecanico();
            if(!mechanicGateway.exists(mecanico))
                throw new BusinessException("No existe el mecánico.");

            breakdownGateway.assgnBreakdown(averia);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }

    }
}
