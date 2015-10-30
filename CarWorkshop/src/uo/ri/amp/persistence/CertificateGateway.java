package uo.ri.amp.persistence;

import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public interface CertificateGateway {
    public void setConnection(Connection connection);
    public void generateCertificates() throws BusinessException;

    public List<Map<String, Object>> listExpertsWithoutCertificate() throws BusinessException;
}
