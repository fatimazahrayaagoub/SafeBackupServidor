package domain;

import java.io.Serializable;

public class PeticionAuth implements Serializable {
    private boolean exito;
    private  String mensaje;

    public PeticionAuth(boolean exito, String mensaje) {
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
        return "PeticionAuth{" +
                "exito=" + exito +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
