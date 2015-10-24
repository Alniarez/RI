package uo.ri.amp.bussness.impl;

import uo.ri.amp.bussness.AdminService;
import uo.ri.amp.bussness.impl.admin.grade.AddGrade;
import uo.ri.amp.bussness.impl.admin.grade.DeleteGrade;
import uo.ri.amp.bussness.impl.admin.grade.ListGrades;
import uo.ri.amp.bussness.impl.admin.grade.UpdateGrade;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public class AdminServiceImpl implements AdminService {

    @Override
    public void addGrade(Curso curso) throws BusinessException {
        AddGrade addGrade = new AddGrade(curso);
        addGrade.execute();
    }

    @Override
    public void deleteGrade(Curso curso) throws BusinessException {
        DeleteGrade deleteGrade = new DeleteGrade(curso);
        deleteGrade.execute();
    }

    @Override
    public void updateGrade(Curso viejo, Curso nuevo) throws BusinessException {
        UpdateGrade updateGrade = new UpdateGrade(viejo, nuevo);
        updateGrade.execute();
    }

    @Override
    public String listGrades() throws BusinessException {
        ListGrades listGrades = new ListGrades();
        listGrades.execute();
        return listGrades.getPrintableResult();
    }

    @Override
    public void addAttendance(Asistencia asistencia) throws BusinessException {

    }

    @Override
    public void deleteAttendance(Asistencia curso) throws BusinessException {

    }

    @Override
    public void updateAttendance(Asistencia viejo, Asistencia nuevo) throws BusinessException {

    }

    @Override
    public String listAttendance(Curso curso) throws BusinessException {
        return null;
    }

    @Override
    public void generateCertificates() throws BusinessException {

    }
}
