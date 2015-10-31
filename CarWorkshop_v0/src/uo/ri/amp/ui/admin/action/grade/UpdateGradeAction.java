package uo.ri.amp.ui.admin.action.grade;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.common.BusinessException;

import java.util.LinkedList;
import java.util.List;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;

/**
 * Created by Jorge.
 */
public class UpdateGradeAction implements Action{

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = leerCadena("Código de curso");
        String nombre = leerCadena("Nombre");
        String descripcion = leerCadena("Descripcion");
        int horasTotales = leerEntero("Horas totales");

        List<Long> tiposVehiculo = new LinkedList<>();
        List<Integer> horasVehiculo = new LinkedList<>();

        do {
            tiposVehiculo.add(leerLong("Tipo de vehículo"));
            horasVehiculo.add(leerEntero("Porcentaje de horas dedicadas vehículo"));
        } while (masTipos());

        //Generar modelo

        List<ContenidoCurso> contenidocuso = new LinkedList<>();
        for(int i=0; i<tiposVehiculo.size();i++){
            TipoVehiculo tipoVehiculo = new TipoVehiculo();
            tipoVehiculo.setId(tiposVehiculo.get(i));

            ContenidoCurso contenidoCurso = new ContenidoCurso();
            contenidoCurso.setSobre(tipoVehiculo);
            contenidoCurso.setPorcentaje(horasVehiculo.get(i));

            contenidocuso.add(contenidoCurso);
        }

        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setHorasTotales(horasTotales);
        curso.setContenidoCurso(contenidocuso);

        // Procesar
        ServiceFactory.getAdminService().updateGrade(curso);


        // Mostrar resultado
        println("Se ha modificado el curso.");
    }

    private boolean masTipos() {
        return leerCadena("¿Añadir más tipos? (s/n)").equalsIgnoreCase("s");
    }
}
