package sample.Server;

import sample.Server.DB.User;
import sample.Server.DB.UserManager;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientHandler extends Thread {
    protected Socket socket;
    public ClientHandler(Socket clientSocket) {
        this.socket = clientSocket;
    }
    @Override
    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            String next;
            SendMassage("Start");
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
                        UserManager userManager = new UserManager();
                        User user = userManager.getUser(Massage[1],Massage[2]);

                        System.out.println(user.getName());

                        if(user.getName()==null){
                            String tmp="SignIn"+"^"+"not_found_user";
                            System.out.println(tmp);
                            SendMassage(tmp);
                        }else {
                            System.out.println("sending Massage ...");
                            String Information = "SignIn" + "^" + user.getName()+"^"+user.getEmail()+"^"+user.getLastName()+"^"+user.getPassword()+"^"+user.getId()+"^"+user.getProfileAddress()+"^"+user.getUserName();
                            SendMassage(Information);
                        }
                    }break;
                    default:
                        System.out.println("Error");
                }
            } while (!next.equals("exit"));
            socket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    private void SendMassage(String Massage) throws IOException {
        Formatter out = new Formatter(socket.getOutputStream());
        out.format(Massage +"\n");
        out.flush();
        System.out.println("Sending Finished##");
    }
}