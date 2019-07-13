package sample.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static final int PORT = 1978;
    public static List<ClientHandler> list = new ArrayList<>();
    public static ServerSocket serverSocket = null;

    public static void main(String args[]) {
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
            list.add(clientHandler);
        }
    }
}