package uo.ri.amp.bussiness.impl.admin.attendance;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.AttendanceGateway;
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
public class ListAttendance {

    private Curso curso;

    public ListAttendance(Curso curso) {
        this.curso = curso;
    }

    private List<Map<String, Object>> result;

    public void execute() throws BusinessException {
        AttendanceGateway attendanceGateway = PersistenceFactory.getAttendanceGateway();
        GradeGateway gradeGateway = PersistenceFactory.getGradeGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            attendanceGateway.setConnection(connection);
            gradeGateway.setConnection(connection);

            if(! gradeGateway.exists(curso))
                throw new BusinessException("No existe el curso.");

            result = attendanceGateway.listAttendance(curso);

        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }

    public String getPrintableResult() {
        StringBuilder sb = new StringBuilder("Nombre\tFecha de finalización\t% de asisetncia\tCalificación");
        for(Map<String, Object> fila: result){
            ;//TODO
        }
        return sb.toString();
    }
}
