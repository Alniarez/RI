package uo.ri.amp.bussiness.impl;

import uo.ri.amp.bussiness.AdminService;
import uo.ri.amp.bussiness.impl.admin.list.ListHoursByMechanic;
import uo.ri.amp.bussiness.impl.admin.list.ListHoursByType;
import uo.ri.amp.bussiness.impl.admin.attendance.AddAttendance;
import uo.ri.amp.bussiness.impl.admin.attendance.DeleteAttendance;
import uo.ri.amp.bussiness.impl.admin.attendance.ListAttendance;
import uo.ri.amp.bussiness.impl.admin.attendance.UpdateAttendance;
import uo.ri.amp.bussiness.impl.admin.certificate.GenerateCertificates;
import uo.ri.amp.bussiness.impl.admin.grade.AddGrade;
import uo.ri.amp.bussiness.impl.admin.grade.DeleteGrade;
import uo.ri.amp.bussiness.impl.admin.grade.ListGrades;
import uo.ri.amp.bussiness.impl.admin.grade.UpdateGrade;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
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
    public void updateGrade(Curso curso) throws BusinessException {
        UpdateGrade updateGrade = new UpdateGrade(curso);
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
        AddAttendance addAttendance = new AddAttendance(asistencia);
        addAttendance.execute();
    }

    @Override
    public void deleteAttendance(Asistencia asistencia) throws BusinessException {
        DeleteAttendance deleteAttendance = new DeleteAttendance(asistencia);
        deleteAttendance.execute();
    }

    @Override
    public void updateAttendance(Asistencia asistencia) throws BusinessException {
        UpdateAttendance updateAttendance = new UpdateAttendance(asistencia);
        updateAttendance.execute();
    }

    @Override
    public String listAttendance(Curso curso) throws BusinessException {
        ListAttendance listAttendance = new ListAttendance(curso);
        listAttendance.execute();
        return listAttendance.getPrintableResult();
    }

    @Override
    public void generateCertificates() throws BusinessException {
        GenerateCertificates generateCertificates = new GenerateCertificates();
        generateCertificates.execute();
    }

    @Override
    public String listHoursByType() throws BusinessException {
        ListHoursByType listHoursByType = new ListHoursByType();
        listHoursByType.execute();
        return listHoursByType.getPrintableResult();
    }

    @Override
    public String listHoursByMechanic(Mecanico mecanico) throws BusinessException {
        ListHoursByMechanic listHoursByMechanic = new ListHoursByMechanic(mecanico);
        listHoursByMechanic.execute();
        return listHoursByMechanic.getPrintableResult();
    }
}
