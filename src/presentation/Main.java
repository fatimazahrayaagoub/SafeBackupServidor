package presentation;

import data.TransferSockets;
import domain.model.MetadatosFichero;
import domain.model.PeticionAuth;
import domain.model.RespuestaAuth;
import domain.model.RespuestaMetadatos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(16000);) {

                    System.out.println("arranca el cliente...........");

                    try (Socket socket = serverSocket.accept()) {
                        System.out.println("conexion acceptada.........");
                        TransferSockets transfer = new TransferSockets(socket);


                        try {

                                // 1. Recibir autenticación
                                PeticionAuth peticion =
                                        transfer.receiveObjectPeticionAuth();

                                if (!validarAutenticacion(peticion, transfer)) {
                                    System.out.println("Autenticación incorrecta. Inténtalo de nuevo.");
                                }

                                System.out.println("Autenticación correcta");

                                // 2. Recibir metadatos
                                MetadatosFichero metadatos =
                                        transfer.receiveObjectMetaDatosFichero();

                                if (!validarMetaDatos(metadatos, transfer)) {
                                    System.out.println("Metadatos incorrectos. Vuelve a intentarlo.");
                                }

                                System.out.println("Metadatos válidos");

                                // 3. Recibir el fichero
                                transfer.receiveBody(metadatos, "./backups_servidor");

                                System.out.println("Fichero recibido correctamente");

                                // Si quieres permitir más copias, continúa.
                                // Si solo quieres una copia por conexión:



                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }


                    }catch (IOException e) {
                        System.out.println("El cliente se ha desconectado.");
                    }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean validarAutenticacion(PeticionAuth peticion, TransferSockets transfer) throws IOException {
        if (peticion == null) {
            System.out.println("petition nula");
            transfer.sendObjectAuth(new RespuestaAuth(false, "peticion nula"));
            return false;
        } else if (!"admin".equalsIgnoreCase(peticion.getUsuario())) {
            System.out.println("ususario incorrecto");
            transfer.sendObjectAuth(new RespuestaAuth(false, "ususario incorrecto"));
            return false;

        } else if (!"1234".equalsIgnoreCase(peticion.getContrasenia())) {
            System.out.println("contraseña no válida");
            transfer.sendObjectAuth(new RespuestaAuth(false, "contrasña incorrecta"));
            return false;

        } else {
            transfer.sendObjectAuth(new RespuestaAuth(true, "la contraseña y el ususario válidos"));
        }
        return true;

    }

    public static boolean validarMetaDatos(MetadatosFichero metadatosFichero, TransferSockets transfer) throws IOException {
        long maximo = 5L * 1024 * 1024;

        if (metadatosFichero.getTamanio() > maximo) {
            transfer.sendObjectMetadatos(new RespuestaMetadatos(false, "el tamaño del archivo supera los 5 bytes"));
            return false;
        } else if (metadatosFichero.getNombre().endsWith(".exe") || metadatosFichero.getNombre().endsWith(".bat")) {
            transfer.sendObjectMetadatos(new RespuestaMetadatos(false, "el nombe del archivo termina con extencion inválida"));
            return false;
        } else {
            transfer.sendObjectMetadatos(new RespuestaMetadatos(true, "el archivo estan bien cumpli con los requisitos"));
        }

        return true;
    }
}