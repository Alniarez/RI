package uo.ri.amp.bussness.impl.admin.grade;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class UpdateGrade {

    private Curso viejo;
    private Curso nuevo;

    public UpdateGrade(Curso viejo, Curso nuevo) {

        this.viejo = viejo;
        this.nuevo = nuevo;
    }

    public void execute() throws BusinessException {

        if(! nuevo.porcentajeContenidoCursoValido())
            throw new BusinessException("La suma de los porcentajes de horas dedicadas a cada tipo de vehiculo deben sumar 100%.");

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

        gradegateway.updateGrade(nuevo, viejo);


    }
}
