package uo.ri.amp.bussiness.impl.foreman;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.BreakdownGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public class ListBreakdownHistory {

    private List<Map<String, Object>> result;

    public ListBreakdownHistory(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    private final Vehiculo vehiculo;


    public void execute() throws BusinessException {
        BreakdownGateway breakdownGateway = PersistenceFactory.getBreakdownGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            breakdownGateway.setConnection(connection);

            if(!breakdownGateway.existsVehicle(vehiculo))
                throw new BusinessException("No existe el vehículo.");

            result = breakdownGateway.listBreakdownHistory(vehiculo);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }

    public String getPrintableResult() {
        return null;
    }


}
