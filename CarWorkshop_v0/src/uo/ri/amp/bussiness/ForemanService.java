package uo.ri.amp.bussiness;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.util.TableBuilder;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface ForemanService {

    /**
     * Añade una avería al sistema. la avería se añade en estado ABIERTA.
     * @param averia a añadir. Debe contener los campos Fecha, Descripción, Vehiculo con Matricula y Mecanico con Id.
     * @throws BusinessException
     */
    void addBreakdown(Averia averia) throws BusinessException;

    /**
     * Modifica una avería en el sistema. Solamente se modifica la descripción.
     * @param averia a modificar. Debe contener los campos Fecha, descripción yVehiculo con Matricula.
     * @throws BusinessException
     */
    void updateBreakdown(Averia averia) throws BusinessException;

    /**
     * Asisga una averia a un mecanico cualificado.
     * @param averia a asignar. Debe contener vehiculo con matriculas y mecánico con Id.
     * @throws BusinessException
     */
    void assignBreakdown(Averia averia) throws BusinessException;

    /**
     * Lista los mecánicos expertos para el timpo de vehículo al que pertenece la matrícula.
     * @param vehiculo debe contener el campo Matricula.
     * @return
     * @throws BusinessException
     */
    TableBuilder listCompetentMechanics(Vehiculo vehiculo) throws BusinessException;

    /**
     * lista el historial de averías para un vehículo.
     * @param vehiculo debe contener el campo Matricula.
     * @return
     * @throws BusinessException
     */
    TableBuilder listBreakdownHistory(Vehiculo vehiculo) throws BusinessException;

    /**
     * Elimina una avería del sistema.
     * @param averia
     * @throws BusinessException
     */
    void removeBreakdown(Averia averia) throws BusinessException;
}
