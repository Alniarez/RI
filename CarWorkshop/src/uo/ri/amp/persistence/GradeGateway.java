package uo.ri.amp.persistence;

import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jorge.
 */
public interface GradeGateway {

    public void setConnection(Connection connection);
    public void addGrade(Curso curso)throws BusinessException;
    public void deleteGrade(Curso curso)throws BusinessException;
    public void updateGrade(Curso curso)throws BusinessException;

    public List<Map<String, Object>> listGrades()throws BusinessException;

    public List<Map<String, Object>> listHoursByType() throws BusinessException;
    public List<Map<String, Object>> listHoursByMechanic(Mecanico mecanico);

    public List<Map<String, Object>> listExpertsWithoutCertificate();

    public boolean exists(Curso curso) throws BusinessException;
}
