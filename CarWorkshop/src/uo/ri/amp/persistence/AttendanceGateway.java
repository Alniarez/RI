package uo.ri.amp.persistence;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface AttendanceGateway {
    public void setConnection(Connection connection);
    public void addAttendance(Asistencia asistencia)throws BusinessException;
    public void deleteAttendance(Asistencia asistencia)throws BusinessException;
    public void updateAttendance(Asistencia viejo, Asistencia nuevo)throws BusinessException;
    public void listAttendance(Curso curso)throws BusinessException;
}
