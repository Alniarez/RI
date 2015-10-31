package uo.ri.amp.model;

/**
 * Created by Jorge.
 */
public class ContenidoCurso {

    int porcentaje;
    Curso pertenece;
    TipoVehiculo sobre;

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Curso getPertenece() {
        return pertenece;
    }

    public void setPertenece(Curso pertenece) {
        this.pertenece = pertenece;
    }

    public TipoVehiculo getSobre() {
        return sobre;
    }

    public void setSobre(TipoVehiculo sobre) {
        this.sobre = sobre;
    }

}
