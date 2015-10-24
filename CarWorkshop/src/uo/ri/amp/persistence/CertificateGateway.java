package uo.ri.amp.persistence;

import uo.ri.common.BusinessException;

import java.sql.Connection;

/**
 * Created by Jorge.
 */
public interface CertificateGateway {
    public void setConnection(Connection connection);
    public void generateCertificates() throws BusinessException;
}
