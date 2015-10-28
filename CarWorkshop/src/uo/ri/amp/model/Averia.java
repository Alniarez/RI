package uo.ri.amp.model;

import java.util.Date;

/**
 * Created by Jorge.
 */
public class Averia {

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AveriaStatus getStatus() {
        return status;
    }

    public void setStatus(AveriaStatus status) {
        this.status = status;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String descripcion;
    Date fecha;
    AveriaStatus status;
    Vehiculo vehiculo;
    Mecanico mecanico;

    public enum AveriaStatus {ABIERTA, ASIGNADA, FINALIZADA, TERMINADA }
}


