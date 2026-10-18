package domain.model;

import java.io.Serializable;

public class RespuestaAuth implements Serializable {
    private boolean exito;
    private  String mensaje;

    public RespuestaAuth(boolean exito, String mensaje) {
        this.exito = exito;
        this.mensaje = mensaje;
    }

    public boolean isExito() {
        return exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "RespuestaAuth{" +
                "exito=" + exito +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
