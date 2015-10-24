package uo.ri.amp.model;

import java.util.Date;

/**
 * Created by Jorge.
 */
public class Asistencia {

    int porcentajeAsistencia;
    private Date fechaComienzo;
    private Date fechaFin;
    long idCurso;
    long idMecanico;
    boolean apto;

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public long getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(long idMecanico) {
        this.idMecanico = idMecanico;
    }

    public int getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public void setPorcentajeAsistencia(int porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
