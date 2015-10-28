package uo.ri.amp.bussiness.impl.admin.list;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public class ListHoursByMechanic {
    //TODO pedir por UI el mecanico
    //TODO comprobar que existe

    private List<Map<String, Object>> result;
    private Mecanico mecanico;

    public ListHoursByMechanic(Mecanico mecanico){
        this.mecanico = mecanico;
    }

    public void execute() throws BusinessException {
        GradeGateway gradeGateway = PersistenceFactory.getGradeGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            gradeGateway.setConnection(connection);

            result = gradeGateway.listHoursByMechanic(mecanico);

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
