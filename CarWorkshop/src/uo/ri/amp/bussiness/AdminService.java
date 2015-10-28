package uo.ri.amp.bussiness;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface AdminService {
    public void addGrade(Curso curso) throws BusinessException;
    public void deleteGrade(Curso curso) throws BusinessException;
    public void updateGrade(Curso curso) throws BusinessException;
    public String listGrades()throws BusinessException;

    public void addAttendance(Asistencia asistencia) throws BusinessException;
    public void deleteAttendance(Asistencia asistencia) throws BusinessException;
    public void updateAttendance(Asistencia asistencia) throws BusinessException;
    public String listAttendance(Curso curso)throws BusinessException;

    public void generateCertificates() throws BusinessException;

    public String listHoursByType() throws BusinessException;

    public String listHoursByMechanic(Mecanico mecanico) throws BusinessException;
}
