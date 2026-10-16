package domain;

import java.io.Serializable;

public class PeticionAuth implements Serializable {
    private String usuario;
    private  String contrasenia;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "PeticionAuth{" +
                "usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

    public PeticionAuth(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;


    }
}
