package uo.ri.amp.bussness.impl.admin.certificate;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jorge.
 */
public class GenerateCertificates {

    public void execute() throws BusinessException {

        CertificateGateway certificateGateway = PersistenceFactory.getCertificateGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            certificateGateway.setConnection(connection);
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }

        certificateGateway.generateCertificates();


    }
}
