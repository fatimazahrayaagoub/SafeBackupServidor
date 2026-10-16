package data;

import domain.FileTransfer;
import domain.PeticionAuth;
import domain.RespuestaAuth;
import domain.RespuestaMetadatos;

import java.io.*;
import java.net.Socket;

public class TransferSockets implements FileTransfer {

    private DataOutputStream dOut;
    private ObjectOutputStream ObjOut;
    private  ObjectInputStream ObjInt;

    public TransferSockets(Socket socket) throws IOException {
        dOut = new DataOutputStream(socket.getOutputStream());
        ObjOut=new ObjectOutputStream(socket.getOutputStream());
        ObjInt=new ObjectInputStream(socket.getInputStream());
    }




    @Override
    public void sendMeta(String path) throws IOException {
        File file = new File(path);

        dOut.writeLong(file.length());
        dOut.flush();


        dOut.writeUTF(file.getName());
        dOut.flush();

    }

    @Override
    public void sendBody(String path) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        File fichero = new File(path);

        try (FileInputStream fileInputStream = new FileInputStream(fichero)) {
            int longitud = 0;
            while((longitud=fileInputStream.read(buffer,0,buffer.length))!=-1){
               dOut.write(buffer,0,longitud);
            }

            dOut.flush();


        }
    }


    @Override
    public void receiveObjectPeticionAuth() throws IOException{
        PeticionAuth pauth= (PeticionAuth) ObjInt.readObject();
    }

    @Override
    public void  sendObjectAuth(RespuestaAuth auth) throws  IOException{


        ObjOut.writeObject(auth);
        ObjOut.flush();
    }

    @Override
    public void sendObjectMetadatos(RespuestaMetadatos metadatos) throws IOException{

        //este objeto va atener el  nombr y el tamaño del fichero del tamaño q quiero enviar
        ObjOut.writeObject(metadatos);
        ObjOut.flush();
    }

}
