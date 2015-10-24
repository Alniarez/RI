package uo.ri.amp.model;

import java.util.List;

/**
 * Created by Jorge.
 */
public class Curso {

    String nombre;
    String descripcion;
    long id;
    int horasTotales;
    List<ContenidoCurso> contenidoCurso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }

    public List<ContenidoCurso> getContenidoCurso() {
        return contenidoCurso;
    }

    public void setContenidoCurso(List<ContenidoCurso> contenidoCurso) {
        this.contenidoCurso = contenidoCurso;
    }

    public boolean porcentajeContenidoCursoValido(){
        int porcentajeAcumulado = 0;
        for(ContenidoCurso cc : contenidoCurso)
            porcentajeAcumulado += cc.porcentaje;
        return porcentajeAcumulado==100;
    }
}
