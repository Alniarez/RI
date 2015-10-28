package uo.ri.amp.model;

import java.util.List;

/**
 * Created by Jorge.
 */
public class Curso {

    String nombre;
    String descripcion;
    String codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    //region Comprobaciones
    public boolean porcentajeAcumuladoDelContenidoCursoEsValido(){
        int porcentajeAcumulado = 0;
        for(ContenidoCurso cc : contenidoCurso)
            porcentajeAcumulado += cc.porcentaje;
        return porcentajeAcumulado==100;
    }
    //endregion

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigo='" + codigo + '\'' +
                ", horasTotales=" + horasTotales +
                '}';
    }
}
