package uo.ri.amp.bussiness.impl.foreman;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.persistence.BreakdownGateway;
import uo.ri.amp.persistence.VehicleGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class UpdateBreakdown {

    private final Averia averia;

    public UpdateBreakdown(Averia averia) {
        this.averia = averia;
    }

    public void execute() throws BusinessException {
        BreakdownGateway breakdownGateway = PersistenceFactory.getBreakdownGateway();
        VehicleGateway vehicleGateway = PersistenceFactory.getVehicleGateway();
        Connection connection = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            vehicleGateway.setConnection(connection);
            breakdownGateway.setConnection(connection);
            if (!vehicleGateway.exists(averia.getVehiculo()))
                throw new BusinessException("No existe el vehículo.");
            averia.getVehiculo().setId(vehicleGateway.getId(averia.getVehiculo()));
            if (!breakdownGateway.exists(averia))
                throw new BusinessException("No existe la avería.");
            breakdownGateway.updateBreakdown(averia);
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }
}
