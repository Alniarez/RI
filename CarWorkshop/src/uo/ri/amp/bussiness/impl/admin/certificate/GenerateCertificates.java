package uo.ri.amp.bussiness.impl.admin.certificate;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.PersistenceFactory;
import uo.ri.amp.model.Certificado;
import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public class GenerateCertificates {

    public void execute() throws BusinessException {

        CertificateGateway certificateGateway = PersistenceFactory.getCertificateGateway();
        Connection connection = null;

        try {
            connection = Jdbc.getConnection();
            connection.setAutoCommit(false);
            certificateGateway.setConnection(connection);

            List<Map<String, Object>> result = certificateGateway.listExpertsWithoutCertificate();

            List<Certificado> certificados = new LinkedList<>();
            for(Map<String, Object> map : result){
                Certificado certificado = new Certificado();
                certificado.setIdmecanico(Long.parseLong(map.get("idMecanico").toString()));
                certificado.setIdTipoVehiculo(Long.parseLong(map.get("idTipoVehiculo").toString()));

                certificados.add(certificado);
                //certificateGateway.generateCertificates(certificado);
            }
            certificateGateway.generateCertificates(certificados);
        } catch (SQLException e) {
            throw new BusinessException("No se encuentra la base de datos.", e);
        } finally {
            Jdbc.close(connection);
        }
    }
}
