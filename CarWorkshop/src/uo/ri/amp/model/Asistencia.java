package uo.ri.amp.model;

import java.util.Date;

/**
 * Created by Jorge.
 */

public class Asistencia {

    int porcentajeAsistencia;
    private Date fechaComienzo;
    private Date fechaFin;
    String idCurso;
    long idMecanico;
    boolean apto;

    public boolean isApto() {
        return apto;
    }

    public String isAptoString(){
        return (isApto()) ? "APTO" : "NO APTO";
    }

    public void setAptoString(String apto){
        this.apto = apto.equalsIgnoreCase("APTO");
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
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

    //region  Comprobaciones
    public boolean relacionEntreFechasValido(){
        return fechaComienzo.before(fechaFin);
    }
    //endregion

    @Override
    public String toString() {
        return "Asistencia{" +
                "porcentajeAsistencia=" + porcentajeAsistencia +
                ", fechaComienzo=" + fechaComienzo +
                ", fechaFin=" + fechaFin +
                ", idCurso='" + idCurso + '\'' +
                ", idMecanico=" + idMecanico +
                ", apto=" + apto +
                '}';
    }
}
