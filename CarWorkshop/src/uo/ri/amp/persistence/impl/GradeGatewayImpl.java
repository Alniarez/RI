package uo.ri.amp.persistence.impl;

import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 * //TODO No hay nada hecho aquí.
 */
public class GradeGatewayImpl implements GradeGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void addGrade(Curso curso) throws BusinessException {

    }

    @Override
    public void deleteGrade(Curso curso) throws BusinessException {

    }

    @Override
    public void updateGrade(Curso viejo, Curso nuevo) throws BusinessException {

    }

    @Override
    public void listGrades() throws BusinessException {

    }
}
