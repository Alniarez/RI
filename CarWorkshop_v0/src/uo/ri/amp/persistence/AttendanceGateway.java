package uo.ri.amp.persistence;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public interface AttendanceGateway {

    public void setConnection(Connection connection);

    /**
     * Añade una asistencia a un curso.
     * @param asistencia a añadir. Debe contener todos los campos.
     * @throws BusinessException
     */
    void addAttendance(Asistencia asistencia)throws BusinessException;

    /**
     * Borra una asistencia a un curso.
     * @param asistencia a borrar. Debe contener los campos idMecanico e idcurso.
     * @throws BusinessException
     */
    public void deleteAttendance(Asistencia asistencia)throws BusinessException;

    /**
     * Modifica una asistencia a un curso.
     * @param asistencia a modificar. Debe contener todos los campos.
     * @throws BusinessException
     */
    public void updateAttendance(Asistencia asistencia)throws BusinessException;

    /**
     * Lista todas las asistencias a un curso determinado.* @param curso a listar. Debe contener el campo codigo.
     * @throws BusinessException
    */
    public List<Map<String, Object>> listAttendance(Curso curso)throws BusinessException;

    /**
     * Comprueba que exista una asistencia.
     * @param asistencia a comrpobar. Debe contener los campos idcurso e idmecanico.
     * @return
     * @throws BusinessException
     */
    public boolean exisists(Asistencia asistencia) throws BusinessException;

    /**
     * Comprueba si existe algun mecanico en un curso.
     * @param curso a comporbar. Debe contener el campo codigo.
     * @return
     * @throws BusinessException
     */
    boolean exisistsAnyMechanic(Curso curso) throws BusinessException;
}
