package presentation;

import data.TransferSockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(16000);) {

            try (Socket socket = serverSocket.accept()) {
                TransferSockets transfer=new TransferSockets(socket);


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}