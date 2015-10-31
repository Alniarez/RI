package uo.ri.amp.persistence;

import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.common.BusinessException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge.
 */
public interface GradeGateway {

    void setConnection(Connection connection);

    /**
     * Añade un curso a la base de datos.
     * @param curso a añadir. Debe tener los datos Código de curso, Nombre, Descripción, horas totales y los contenidos que se imparten.
     * @throws BusinessException en caso de que no se cumpla alguna de las restricciones.
     */
    void addGrade(Curso curso)throws BusinessException;

    /**
     * Borra un curso de la base de datos.
     * @param curso a borrar. Debe tener el código de curso.
     * @throws BusinessException en caso de que no se cumpla alguna de las restricciones.
     */
    void deleteGrade(Curso curso)throws BusinessException;

    /**
     * Modifica un curso en base de datos. El curso que se modifica es el indicado por el código del objeto.
     * @param curso a actualizar. Debe tener los datos Código de curso, Nombre, Descripción, horas totales y los contenidos que se imparten.
     * @throws BusinessException en caso de que no se cumpla alguna de las restricciones.
     */
    void updateGrade(Curso curso)throws BusinessException;

    /**
     * Lista todos los cursos.
     */
    List<Map<String, Object>> listGrades()throws BusinessException;

    /**
     * Lista todos los tipos de vehículos con todos los mecánicos que han cursado sobre ellos y las horas dedicadas a estos.
     * Sólo se contabilizan horas si sus asisteciase considera apto.
     * @throws BusinessException
     */
    List<Map<String, Object>> listHoursByType() throws BusinessException;

    /**
     * Lista el entrenamiento que ha recibido un determinado mecánico para todos los tipos de vehículo.
     * Solo se condirera cuando sua sistencia a un curso ha sido apta.
     * @param mecanico para el que se listan sus horas. Debe contener el campo Id.
     * @throws BusinessException
     */
    List<Map<String, Object>> listHoursByMechanic(Mecanico mecanico) throws BusinessException;

    /**
     * Comprueba que exista un curso determinado.
     * @param curso a comprobar. Debe contener el campo codigo.
     * @return
     * @throws BusinessException
     */
    boolean exists(Curso curso) throws BusinessException;
}
