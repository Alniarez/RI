package uo.ri.amp.bussiness.impl.admin.list;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public class ListHoursByType {
    private List<Map<String, Object>> result;

    public void execute() throws BusinessException {
        GradeGateway gradeGateway = PersistenceFactory.getGradeGateway();
        Connection connection = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            gradeGateway.setConnection(connection);
            result = gradeGateway.listHoursByType();
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }

    public String getPrintableResult() {
        StringBuilder sb = new StringBuilder();
        String tipo = "";
        for (Map<String, Object> map : result) {
            if (!tipo.equalsIgnoreCase(map.get("nombreTiposHeviculo").toString())) {
                tipo = map.get("nombreTiposHeviculo").toString();
                sb.append(tipo);
                sb.append("\n");
            }
            sb.append("\t");
            sb.append(map.get("nombre"));
            sb.append(" ");
            sb.append(map.get("apellidos"));
            sb.append(" ");
            sb.append(map.get("horas"));
            sb.append("\n");
        }
        return sb.toString();
    }
}
