package uo.ri.amp.bussiness;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface AdminService {

    void addGrade(Curso curso) throws BusinessException;

    void deleteGrade(Curso curso) throws BusinessException;

    void updateGrade(Curso curso) throws BusinessException;

    String listGrades() throws BusinessException;

    void addAttendance(Asistencia asistencia) throws BusinessException;

    void deleteAttendance(Asistencia asistencia) throws BusinessException;

    void updateAttendance(Asistencia asistencia) throws BusinessException;

    String listAttendance(Curso curso) throws BusinessException;

    void generateCertificates() throws BusinessException;

    String listHoursByType() throws BusinessException;

    String listHoursByMechanic(Mecanico mecanico) throws BusinessException;
}
