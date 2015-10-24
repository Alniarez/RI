package uo.ri.amp.bussness;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface AdminService {
    public void addGrade(Curso curso) throws BusinessException;
    public void deleteGrade(Curso curso) throws BusinessException;
    public void updateGrade(Curso viejo, Curso nuevo) throws BusinessException;
    public String listGrades()throws BusinessException;

    public void addAttendance(Asistencia asistencia) throws BusinessException;
    public void deleteAttendance(Asistencia curso) throws BusinessException;
    public void updateAttendance(Asistencia viejo, Asistencia nuevo) throws BusinessException;
    public String listAttendance(Curso curso)throws BusinessException;

    public void generateCertificates() throws BusinessException;
}
