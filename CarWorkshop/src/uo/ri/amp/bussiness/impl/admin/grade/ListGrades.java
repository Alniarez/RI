package uo.ri.amp.bussiness.impl.admin.grade;

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
public class ListGrades {

    private List<Map<String, Object>> result;

    public void execute() throws BusinessException {
        GradeGateway gradegateway = PersistenceFactory.getGradeGateway();
        Connection connection = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            gradegateway.setConnection(connection);
            result = gradegateway.listGrades();
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }

    public String getPrintableResult() {
        StringBuilder sb = new StringBuilder("Código\tNombre del curso\tHoras totales\tDescripción\n");
        for (Map<String, Object> fila : result) {
            sb.append(fila.get("codigo"));
            sb.append("\t\t");
            sb.append(fila.get("nombre"));
            sb.append("\t\t");
            sb.append(fila.get("horastotales"));
            sb.append("\t\t");
            sb.append(fila.get("descripcion"));
            sb.append("\n");
        }
        return sb.toString();
    }
}
