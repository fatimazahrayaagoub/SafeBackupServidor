package domain;

import java.io.Serializable;

public class MetadatosFichero implements Serializable {
    private String nombre;
    private long tamanio;

    public MetadatosFichero(String nombre, long tamanio) {
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
        return "Metadatos{" +
                "nombre='" + nombre + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}
