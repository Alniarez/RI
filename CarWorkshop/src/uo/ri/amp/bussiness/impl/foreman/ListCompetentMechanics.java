package uo.ri.amp.bussiness.impl.foreman;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.BreakdownGateway;
import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.amp.persistence.MechanicGateway;
import uo.ri.amp.persistence.VehicleGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public class ListCompetentMechanics {

    private List<Map<String, Object>> result;

    public ListCompetentMechanics(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    private final Vehiculo vehiculo;

    public void execute()  throws BusinessException {
        VehicleGateway vehicleGateway = PersistenceFactory.getVehicleGateway();
        CertificateGateway certificateGateway = PersistenceFactory.getCertificateGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            vehicleGateway.setConnection(connection);
            certificateGateway.setConnection(connection);

            if(!vehicleGateway.exists(vehiculo))
                throw new BusinessException("No existe el vehículo.");

            vehiculo.setId(vehicleGateway.getId(vehiculo));

            result = certificateGateway.listCompetentMechanics(vehiculo);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }

    public String getPrintableResult() {
        StringBuilder sb = new StringBuilder("ID Mecánico experto");
        for(Map<String,Object> map : result){
            sb.append(map.get("idMecanico"));
            sb.append("\n");
        }
        return null;
    }
}
