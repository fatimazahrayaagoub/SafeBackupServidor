package domain;

import java.io.IOException;

public interface FileTransfer {
    public void sendMeta(String path) throws IOException;

    public void receiveBody(String path) throws IOException;





    public void receiveObjectPeticionAuth() throws IOException;

    public void sendObjectAuth(RespuestaAuth auth) throws IOException;

    public void receiveObjectMetaDatosFichero() throws IOException;

    public void sendObjectMetadatos(RespuestaMetadatos metadatos) throws IOException;
}
