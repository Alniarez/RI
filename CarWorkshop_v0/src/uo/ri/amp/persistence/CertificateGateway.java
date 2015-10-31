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

    void setConnection(Connection connection);

    /**
     * Genera una lista de certificados. los certificados se generan con fecha actual.
     * @param certificados lista de certificados a añadir. Cada uno de ellos debe contener IdMecanico e IdTipoVehículo
     * @throws BusinessException
     */
    void generateCertificates(List<Certificado> certificados) throws BusinessException;

    /**
     * Lista los mecánicos expertos que no tienen un certificado.
     * @return
     * @throws BusinessException
     */
    List<Map<String, Object>> listExpertsWithoutCertificate() throws BusinessException;

    /**
     * Lista los mecánicos expertos para el timpo de vehículo al que pertenece la matrícula.
     * @param vehiculo debe contener el campo Matricula.
     * @return
     * @throws BusinessException
     */
    List<Map<String,Object>> listCompetentMechanics(Vehiculo vehiculo) throws BusinessException;


    /**
     * Comprueba si un mecánico es competente para un tipo de vehículo determinado.
     * @param averia debe contener emcanico con Id y cehiculo con id.
     * @return
     * @throws BusinessException
     */
    boolean isCompetent(Averia averia) throws BusinessException;
}
