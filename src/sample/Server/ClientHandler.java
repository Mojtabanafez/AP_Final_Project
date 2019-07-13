package sample.Server;

import sample.Server.DB.User;
import sample.Server.DB.UserManager;

import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientHandler extends Thread {
    protected Socket socket;
    public ClientHandler(Socket clientSocket) {
        this.socket = clientSocket;
    }
    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            Formatter out = new Formatter(socket.getOutputStream());
            String next;
            do {
                next = in.nextLine();
                System.out.println(next + "  " + socket.toString());
                String[]Massage=next.split("\\^");
                switch (Massage[0]){
                    case "SignUp":{
                        User user = new User();
                        user.setLastName(Massage[2]);
                        user.setName(Massage[5]);
                        user.setPassword(Massage[3]);
                        user.setUserName(Massage[4]);
                        user.setEmail(Massage[1]);
                        UserManager userManager = new UserManager();
                        userManager.Insert(user);
                    }break;
                    case "SignIn":{
                    }break;
                    default:
                        System.out.println("Error");
                }



//                out.format("Thank you#");
//                out.flush();
            } while (!next.equals("exit"));
            socket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}