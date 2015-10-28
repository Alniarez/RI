package uo.ri.amp.persistence;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public interface AttendanceGateway {
    public void setConnection(Connection connection);
    public void addAttendance(Asistencia asistencia)throws BusinessException;
    public void deleteAttendance(Asistencia asistencia)throws BusinessException;
    public void updateAttendance(Asistencia asistencia)throws BusinessException;
    public List<Map<String, Object>> listAttendance(Curso curso)throws BusinessException;

    public boolean exisists(Asistencia asistencia);

    boolean exisistsAnyMechanic(Curso curso);
}
