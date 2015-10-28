package uo.ri.amp.bussiness.impl.admin.grade;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.AttendanceGateway;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class DeleteGrade {

    private Curso curso;

    public DeleteGrade(Curso curso) {

        this.curso = curso;
    }

    public void execute() throws BusinessException {

        GradeGateway gradegateway = PersistenceFactory.getGradeGateway();
        AttendanceGateway attendanceGateway = PersistenceFactory.getAttendanceGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            gradegateway.setConnection(connection);
            attendanceGateway.setConnection(connection);

            if(!gradegateway.exists(curso))
                throw new BusinessException("No existe un curso con este código.");

            if(attendanceGateway.exisistsAnyMechanic(curso))
                throw new BusinessException("No se pueden eliminar cursos con mecanicos matriculados.");

            gradegateway.deleteGrade(curso);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }
}
