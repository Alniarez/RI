package uo.ri.amp.ui.admin.action.grade;


import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.common.BusinessException;

import java.util.LinkedList;
import java.util.List;

public class AddGradeAction implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        Long codigo = Console.readLong("Código de curso");
        String nombre = Console.readString("Nombre");
        String descripcion = Console.readString("Descripcion");
        int horasTotales = Console.readInt("Horas totales");

        List<String> tiposVehiculo = new LinkedList<>();
        List<Integer> horasVehiculo = new LinkedList<>();

        do {
            tiposVehiculo.add(Console.readString("Tipo de vehículo"));
            horasVehiculo.add(Console.readInt("Porcentaje de horas dedicadas vehículo"));
        } while (masTipos());

        //Generar modelo

        List<ContenidoCurso> contenidocuso = new LinkedList<>();
        for(int i=0; i<tiposVehiculo.size();i++){
            TipoVehiculo tipoVehiculo = new TipoVehiculo();
            tipoVehiculo.setNombre(tiposVehiculo.get(i));

            ContenidoCurso contenidoCurso = new ContenidoCurso();
            contenidoCurso.setSobre(tipoVehiculo);
            contenidoCurso.setPorcentaje(horasVehiculo.get(i));

            contenidocuso.add(contenidoCurso);
        }

        Curso curso = new Curso();
        curso.setId(codigo);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setHorasTotales(horasTotales);
        curso.setContenidoCurso(contenidocuso);

        // Procesar
        ServiceFactory.getAdminService().addGrade(curso);


        // Mostrar resultado
        Console.println("Se ha añadido el curso.");
    }

    private boolean masTipos(){
        return Console.readString("¿Añadir más tipos? (s/n) ")
                .equalsIgnoreCase("s");
    }
}
