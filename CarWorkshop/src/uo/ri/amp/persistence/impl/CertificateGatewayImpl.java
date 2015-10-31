package uo.ri.amp.persistence.impl;

import alb.util.jdbc.Jdbc;
import uo.ri.amp.conf.Conf;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Certificado;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.common.BusinessException;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public class CertificateGatewayImpl implements CertificateGateway {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    private void generateCertificate(Certificado certicado) throws BusinessException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(Conf.get("expertos_add"));
            ps.setLong(1, certicado.getIdmecanico());
            ps.setLong(2, certicado.getIdTipoVehiculo());
            ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos." + e.getSQLState(), e);
        } finally {
            Jdbc.close(ps);
        }
    }

    @Override
    public void generateCertificates(List<Certificado> certificados) throws BusinessException {
        for (Certificado certificado : certificados)
            generateCertificate(certificado);
        try {
            connection.commit();
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        }
    }

    @Override
    public List<Map<String, Object>> listExpertsWithoutCertificate() throws BusinessException {
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(Conf.get("expertos_sin_certificado"));
            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("idMecanico", rs.getLong(2));
                map.put("idTipoVehiculo", rs.getLong(1));
                result.add(map);
            }
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, st);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> listCompetentMechanics(Vehiculo vehiculo) throws BusinessException {
        List<Map<String, Object>> result = new LinkedList<>();
        Map<String, Object> map;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(Conf.get("vehiculo_select_tipo"));
            st.setLong(1, vehiculo.getId());
            rs = st.executeQuery();
            while (rs.next()) {
                map = new HashMap<String, Object>();
                map.put("idMecanico", rs.getLong(1));
                map.put("nombre", rs.getString(2));
                map.put("apellido", rs.getString(2));
                result.add(map);
            }
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, st);
        }
        return result;
    }

    @Override
    public boolean isCompetent(Averia averia) throws BusinessException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(Conf.get("experto_select"));
            ps.setLong(1, averia.getMecanico().getId());
            ps.setLong(2, averia.getVehiculo().getId());
            rs = ps.executeQuery();
            while (rs.next())
                return true;
            return false;
        } catch (SQLException e) {
            rollback();
            throw new BusinessException("Se produjo un error en la base de datos.", e);
        } finally {
            Jdbc.close(rs, ps);
        }
    }

    private void rollback() {
        if(connection==null)
            return;
        try {
            connection.rollback();
        } catch (SQLException ignored) {
        }
    }
}
