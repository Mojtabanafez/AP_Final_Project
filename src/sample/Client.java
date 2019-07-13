package sample;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Formatter;
import java.util.Scanner;

public class Client extends Thread {
    static Socket socket;

    static {
        try {
            socket = new Socket("127.0.0.1", 1978);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Scanner socketIn;

    static {
        try {
            socketIn = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Formatter socketOut;

    static {
        try {
            socketOut = new Formatter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            do {
                String received = socketIn.next();
                System.out.println("received: " + received);
            } while (true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public static void main(String[] args) {

        try {
            Scanner systemIn = new Scanner(System.in);
            String next;
            do {
                next = systemIn.next();
                socketOut.format(next + "\n");
                socketOut.flush();
                String received = socketIn.next();
                System.out.println("received: " + received);
            } while (!next.equals("exit"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void SendMassage(String massage) {
        try {
            socketOut.format(massage + "\n");
            socketOut.flush();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}