package uo.ri.amp.ui.admin.action.grade;


import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.common.BusinessException;

import java.util.LinkedList;
import java.util.List;

public class AddGradeAction implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = Console.readString("Código de curso");
        String nombre = Console.readString("Nombre");
        String descripcion = Console.readString("Descripcion");
        String horasTotales = Console.readString("Horas totales");

        List<String> tiposVehiculo = new LinkedList<>();
        List<String> horasVehiculo = new LinkedList<>();

        // Procesar




        // Mostrar resultado
        Console.println("Nuevo mecánico añadido");
    }
}
