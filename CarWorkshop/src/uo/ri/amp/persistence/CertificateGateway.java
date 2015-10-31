package uo.ri.amp.persistence;

import uo.ri.amp.model.*;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public interface CertificateGateway {

    public void setConnection(Connection connection);

    public void generateCertificates(List<Certificado> certificados) throws BusinessException;

    public List<Map<String, Object>> listExpertsWithoutCertificate() throws BusinessException;

    public List<Map<String,Object>> listCompetentMechanics(Vehiculo vehiculo) throws BusinessException;

    boolean isCompetent(Averia averia) throws BusinessException;
}
