package domain.repository;

import domain.model.MetadatosFichero;
import domain.model.PeticionAuth;
import domain.model.RespuestaAuth;
import domain.model.RespuestaMetadatos;

import java.io.IOException;

public interface FileTransfer {


    public PeticionAuth receiveObjectPeticionAuth() throws IOException, ClassNotFoundException;

    public void sendObjectAuth(RespuestaAuth auth) throws IOException;

    public MetadatosFichero receiveObjectMetaDatosFichero() throws IOException, ClassNotFoundException;

    public void sendObjectMetadatos(RespuestaMetadatos metadatos) throws IOException;

    public void receiveBody(MetadatosFichero metadatosFichero, String directory) throws IOException;

}