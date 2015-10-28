package uo.ri.amp.bussiness.impl.admin.attendance;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.AttendanceGateway;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.amp.persistence.MechanicGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */


public class AddAttendance {

    private Asistencia asistencia;

    public AddAttendance(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public void execute() throws BusinessException {

        if(!asistencia.relacionEntreFechasValido())
            throw new BusinessException("Los datos de las fechas son erróneos.");

        if(asistencia.getPorcentajeAsistencia()<85 && asistencia.isApto())
            throw new BusinessException("Para ser apto se debe cumplir: [Porcentaje asistencia > 84].");

        AttendanceGateway attendanceGateway = PersistenceFactory.getAttendanceGateway();

        GradeGateway gradeGateway = PersistenceFactory.getGradeGateway();
        MechanicGateway mechanicGateway = PersistenceFactory.getMechanicGateway();

        Curso curso = new Curso();
        curso.setCodigo(asistencia.getIdCurso());

        Mecanico mecanico = new Mecanico();
        mecanico.setId(asistencia.getIdMecanico());

        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);

            attendanceGateway.setConnection(connection);
            gradeGateway.setConnection(connection);
            mechanicGateway.setConnection(connection);

            if(gradeGateway.exists(curso))
                throw new BusinessException("No existe el curso especificado.");
            if(! mechanicGateway.exists(mecanico))
                throw new BusinessException("No existe el mecánico especificado.");

            attendanceGateway.addAttendance(asistencia);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }
}
