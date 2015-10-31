package uo.ri.amp.bussiness;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.util.TableBuilder;
import uo.ri.common.BusinessException;

/**
 * Created by Jorge.
 */
public interface AdminService {

    /**
     * Añade un curso a la base de datos.
     * @param curso a añadir. Debe tener los datos Código de curso, Nombre, Descripción, horas totales y los contenidos que se imparten.
     * @throws BusinessException en caso de que no se cumpla alguna de las restricciones.
     */
    void addGrade(Curso curso) throws BusinessException;

    /**
     * Borra un curso de la base de datos.
     * @param curso a borrar. Debe tener el código de curso.
     * @throws BusinessException en caso de que no se cumpla alguna de las restricciones.
     */
    void deleteGrade(Curso curso) throws BusinessException;

    /**
     * Modifica un curso en base de datos. El curso que se modifica es el indicado por el código del objeto.
     * @param curso a actualizar. Debe tener los datos Código de curso, Nombre, Descripción, horas totales y los contenidos que se imparten.
     * @throws BusinessException en caso de que no se cumpla alguna de las restricciones.
     */
    void updateGrade(Curso curso) throws BusinessException;

    /**
     * Lista todos los cursos.
     */
    TableBuilder listGrades() throws BusinessException;

    /**
     * Añade una asistencia a un curso.
     * @param asistencia a añadir. Debe contener todos los campos.
     * @throws BusinessException
     */
    void addAttendance(Asistencia asistencia) throws BusinessException;

    /**
     * Borra una asistencia a un curso.
     * @param asistencia a borrar. Debe contener los campos idMecanico e idcurso.
     * @throws BusinessException
     */
    void deleteAttendance(Asistencia asistencia) throws BusinessException;

    /**
     * Modifica una asistencia a un curso.
     * @param asistencia a modificar. Debe contener todos los campos.
     * @throws BusinessException
     */
    void updateAttendance(Asistencia asistencia) throws BusinessException;

    /**
     * Lista todas las asistencias a un curso determinado.
     * @param curso a listar. Debe contener el campo codigo.
     * @throws BusinessException
     */
    TableBuilder listAttendance(Curso curso) throws BusinessException;

    /**
     * Genera los certificados para aquellos mecánicos expertos que no tienen certificado.
     * El certificado se genera con la fecha actual.
     * @throws BusinessException
     */
    void generateCertificates() throws BusinessException;

    /**
     * Lista todos los tipos de vehículos con todos los mecánicos que han cursado sobre ellos y las horas dedicadas a estos.
     * Sólo se contabilizan horas si sus asisteciase considera apto.
     * @throws BusinessException
     */
    String listHoursByType() throws BusinessException;

    /**
     * Lista el entrenamiento que ha recibido un determinado mecánico para todos los tipos de vehículo.
     * Solo se condirera cuando sua sistencia a un curso ha sido apta.
     * @param mecanico para el que se listan sus horas. Debe contener el campo Id.
     * @throws BusinessException
     */
    String listHoursByMechanic(Mecanico mecanico) throws BusinessException;
}
