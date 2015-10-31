package uo.ri.amp.bussiness.impl.foreman;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.BreakdownGateway;
import uo.ri.amp.persistence.VehicleGateway;
import uo.ri.amp.util.TableBuilder;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public class ListBreakdownHistory {

    private List<Map<String, Object>> result;
    private final Vehiculo vehiculo;

    public ListBreakdownHistory(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void execute() throws BusinessException {
        BreakdownGateway breakdownGateway = PersistenceFactory.getBreakdownGateway();
        VehicleGateway vehicleGateway = PersistenceFactory.getVehicleGateway();
        Connection connection = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            breakdownGateway.setConnection(connection);
            vehicleGateway.setConnection(connection);
            if (!vehicleGateway.exists(vehiculo))
                throw new BusinessException("No existe el vehículo.");
            vehiculo.setId(vehicleGateway.getId(vehiculo));
            result = breakdownGateway.listBreakdownHistory(vehiculo);
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }

    public TableBuilder getPrintableResult() {
    	TableBuilder tb = new TableBuilder();
    	tb.addRow("Fecha","Descripción","Status");
    	tb.addRow("----------","----------","----------");
        for (Map<String, Object> map : result) {
           tb.addRow(map.get("fecha").toString(),map.get("descripcion").toString(),map.get("status").toString());
        }
        return tb;
    }
}
