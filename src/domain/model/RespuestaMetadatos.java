package domain.model;

import java.io.Serializable;

public class RespuestaMetadatos implements Serializable {
    private boolean aceptado;
    private String motivo;



    public RespuestaMetadatos(boolean aceptado, String motivo) {
        this.aceptado = aceptado;
        this.motivo = motivo;

    }
    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "RespuestaMetadatos{" +
                "aceptado=" + aceptado +
                ", motivo='" + motivo + '\'' +
                '}';
    }

}
