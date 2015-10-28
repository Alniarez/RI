package uo.ri.amp.persistence.impl;

import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.common.BusinessException;

import java.sql.Connection;

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
}
