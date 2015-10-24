package uo.ri.amp.model;

import alb.util.money.Money;

/**
 * Created by Jorge.
 */
public class TipoVehiculo {

    String nombre;
    Money precioHora;
    int horasMaestria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Money getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Money precioHora) {
        this.precioHora = precioHora;
    }

    public int getHorasMaestria() {
        return horasMaestria;
    }

    public void setHorasMaestria(int horasMaestria) {
        this.horasMaestria = horasMaestria;
    }
}
