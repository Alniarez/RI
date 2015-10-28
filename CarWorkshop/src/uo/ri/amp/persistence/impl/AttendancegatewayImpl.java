package uo.ri.amp.persistence.impl;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.AttendanceGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public class AttendancegatewayImpl implements AttendanceGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {

    }

    @Override
    public void addAttendance(Asistencia asistencia) throws BusinessException {

    }

    @Override
    public void deleteAttendance(Asistencia asistencia) throws BusinessException {

    }

    @Override
    public void updateAttendance(Asistencia asistencia) throws BusinessException {

    }

    @Override
    public List<Map<String, Object>> listAttendance(Curso curso) throws BusinessException {
        return null;
    }

    @Override
    public boolean exisists(Asistencia asistencia) {
        return false;
    }

    @Override
    public boolean exisistsAnyMechanic(Curso curso) {
        return false;
    }
}
