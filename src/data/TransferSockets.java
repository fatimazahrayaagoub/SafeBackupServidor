package data;

import domain.*;

import java.io.*;
import java.net.Socket;

public class TransferSockets implements FileTransfer {

    private ObjectOutputStream ObjOut;
    private ObjectInputStream ObjInt;

    public TransferSockets(Socket socket) throws IOException {
        ObjOut = new ObjectOutputStream(socket.getOutputStream());
        ObjOut.flush();
        ObjInt = new ObjectInputStream(socket.getInputStream());
    }


    @Override
    public PeticionAuth receiveObjectPeticionAuth() throws IOException, ClassNotFoundException {
        return (PeticionAuth) ObjInt.readObject();
    }

    @Override
    public void sendObjectAuth(RespuestaAuth auth) throws IOException {

        ObjOut.writeObject(auth);
        ObjOut.flush();
    }

    @Override
    public MetadatosFichero receiveObjectMetaDatosFichero() throws IOException, ClassNotFoundException {
        return (MetadatosFichero) ObjInt.readObject();
    }

    @Override
    public void sendObjectMetadatos(RespuestaMetadatos metadatos) throws IOException {

        ObjOut.writeObject(metadatos);
        ObjOut.flush();
    }

    @Override
    public void receiveBody(MetadatosFichero metadatosFichero, String directory) throws IOException {
        byte[] buffer = new byte[8 * 1024];

        File carpeta = new File(directory);

        if (!carpeta.exists() && !carpeta.mkdirs()) {
            throw new IOException("No se pudo crear el directorio");
        }

        File file = new File(carpeta, metadatosFichero.getNombre());
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            long size = metadatosFichero.getTamanio();
            while (size > 0) {

                int longitud = ObjInt.read(buffer, 0, (int) Math.min(buffer.length, size));

                if (longitud == -1) {
                    throw new EOFException("El fichero se ha recibido incompleto");
                }

                fileOutputStream.write(buffer, 0, longitud);
                size -= longitud;

            }
            fileOutputStream.flush();
        }

    }


}
