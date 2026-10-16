package domain;

import java.io.Serializable;

public class RespuestaMetadatos implements Serializable {
    private String nombre;
    private long tamanio;

    public RespuestaMetadatos(String nombre, long tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "RespuestaMetadatos{" +
                "nombre='" + nombre + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}
