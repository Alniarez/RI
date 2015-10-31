package uo.ri.amp.bussiness.impl.admin.grade;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.amp.persistence.VehicleGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class AddGrade {

    private Curso curso;

    public AddGrade(Curso curso) {
        this.curso = curso;
    }

    public void execute() throws BusinessException {
        if (!curso.porcentajeAcumuladoDelContenidoCursoEsValido())
            throw new BusinessException("La suma de los porcentajes de horas dedicadas a cada tipo de vehiculo deben sumar 100%.");
        if (curso.getHorasTotales() <= 0)
            throw new BusinessException("Debe introducir un número de horas superior a cero.");
        if (curso.contenidosRepetidos())
            throw new BusinessException("No se puede repetir el mismo tipo de vehículo en los contenidos.");
        GradeGateway gradegateway = PersistenceFactory.getGradeGateway();
        VehicleGateway vehicleGateway = PersistenceFactory.getVehicleGateway();
        Connection connection = null;
        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            gradegateway.setConnection(connection);
            vehicleGateway.setConnection(connection);
            if (gradegateway.exists(curso))
                throw new BusinessException("Ya existe un curso con este código.");
            for (ContenidoCurso cc : curso.getContenidoCurso())
                if (!vehicleGateway.existsType(cc.getSobre()))
                    throw new BusinessException("No existe un tipo de vehículo.");
            gradegateway.addGrade(curso);
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }
}
