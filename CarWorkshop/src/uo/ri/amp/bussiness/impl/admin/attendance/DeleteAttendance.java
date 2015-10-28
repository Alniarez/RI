package uo.ri.amp.bussiness.impl.admin.attendance;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.persistence.AttendanceGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class DeleteAttendance {

    private Asistencia asistencia;

    public DeleteAttendance(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public void execute() throws BusinessException {

        AttendanceGateway attendanceGateway= PersistenceFactory.getAttendanceGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            attendanceGateway.setConnection(connection);

            if(! attendanceGateway.exisists(asistencia))
                throw new BusinessException("No existe esta asistenia.");

            attendanceGateway.deleteAttendance(asistencia);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }


    }
}
