package uo.ri.amp.persistence.impl;

import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public class CertificateGatewayImpl implements CertificateGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {

    }

    @Override
    public void generateCertificates() throws BusinessException {

    }

    @Override
    public List<Map<String, Object>> listExpertsWithoutCertificate()throws BusinessException {
        return null;
    }
}
