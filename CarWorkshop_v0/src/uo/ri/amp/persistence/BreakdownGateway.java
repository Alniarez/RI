package uo.ri.amp.persistence;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public interface BreakdownGateway {

    void setConnection(Connection connection);

    /**
     * Añade una avería al sistema. la avería se añade en estado ABIERTA.
     * @param averia a añadir. Debe contener los campos Vehiculo con Id, Mecanico con Id, Fecha y Descripción.
     * @throws BusinessException
     */
    void addBreakdown(Averia averia) throws BusinessException;

    /**
     * Elimina una avería del sistema.
     * @param averia
     * @throws BusinessException
     */
    void removeBreakdown(Averia averia) throws BusinessException;

    /**
     * Comprueba si existe una avería.
     * @param averia
     * @return
     * @throws BusinessException
     */
    boolean exists(Averia averia) throws BusinessException;

    /**
     * lista los mecánicos expertos para el timpo de vehículo al que pertenece la matrícula.
     * @param averia
     * @return
     * @throws BusinessException
     */
    void assgnBreakdown(Averia averia) throws BusinessException;

    /**
     * Modifica una avería en el sistema. Solamente se modifica la descripción.
     * @param averia a modificar. Debe contener los campos Vehiculo con Matricula, Fecha y descripción.
     * @throws BusinessException
     */
    void updateBreakdown(Averia averia) throws BusinessException;

    /**
     * lista el historial de averías para un vehículo.
     * @param vehiculo debe contener el campo Matricula.
     * @return
     * @throws BusinessException
     */
    List<Map<String,Object>> listBreakdownHistory(Vehiculo vehiculo) throws BusinessException;


}
