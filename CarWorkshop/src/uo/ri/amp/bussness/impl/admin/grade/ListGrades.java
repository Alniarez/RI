package uo.ri.amp.bussness.impl.admin.grade;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class ListGrades {


    public void execute() throws BusinessException {

        GradeGateway gradegateway = PersistenceFactory.getGradeGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            gradegateway.setConnection(connection);
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }

        gradegateway.listGrades();
        //Todo guardar serultado en esta clase
    }

    public String getPrintableResult() {
        //TODO procesar el resultado pasandolo a una cadena imprimible
        return  null;

    }
}
