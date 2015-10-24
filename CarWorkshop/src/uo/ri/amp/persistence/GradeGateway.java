package uo.ri.amp.persistence;

import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface GradeGateway {
    public void setConnection(Connection connection);
    public void addGrade(Curso curso)throws BusinessException;
    public void deleteGrade(Curso curso)throws BusinessException;
    public void updateGrade(Curso viejo, Curso nuevo)throws BusinessException;
    public void listGrades()throws BusinessException;

}
