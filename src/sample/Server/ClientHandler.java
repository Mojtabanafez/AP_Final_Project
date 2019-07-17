package sample.Server;

import sample.Server.DB.PrivateMassage;
import sample.Server.DB.PrivateMassageManager;
import sample.Server.DB.User;
import sample.Server.DB.UserManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.List;
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
            do {
                next = in.nextLine();
                System.out.println(next + "  " + socket.toString());
                String[]Massage=next.split("\\^");
                UserManager userManager = new UserManager();
                PrivateMassageManager privateMassageManager = new PrivateMassageManager();

                switch (Massage[0]){
                    case "SignUp":{
                        User user = new User();
                        user.setLastName(Massage[2]);
                        user.setName(Massage[5]);
                        user.setPassword(Massage[3]);
                        user.setUserName(Massage[4]);
                        user.setEmail(Massage[1]);
                        userManager.Insert(user);
                        User user1 = userManager.getUser(user.getPassword(),user.getUserName());
                        SendMassage(String.valueOf(user1.getId()));
                    }break;
                    case "SignIn":{
                        User user = userManager.getUser(Massage[1],Massage[2]);
                        System.out.println(user.getName());
                        if(user.getName()==null){
                            String tmp="SignIn"+"^"+"not_found_user";
                            System.out.println(tmp);
                            SendMassage(tmp);
                        }else {
                            System.out.println("sending PrivateMassage ...");
                            String Information = "SignIn" + "^" + user.getName()+"^"+user.getEmail()+"^"+user.getLastName()+"^"+user.getPassword()+"^"+user.getId()+"^"+user.getProfileAddress()+"^"+user.getUserName();
                            SendMassage(Information);
                        }
                    }break;
                    case "searchUser":{
                        User user=userManager.getUser(Massage[1]);
                        System.out.println(user);
                        if (user.getName()==null){
                            String tmp = "search"+"^"+"not_found_user";
                            SendMassage(tmp);
                        }else {
                            String Information = "SignIn" + "^" + user.getName()+"^"+user.getEmail()+"^"+user.getLastName()+"^"+user.getPassword()+"^"+user.getId()+"^"+user.getProfileAddress()+"^"+user.getUserName();
                            SendMassage(Information);
                        }
                    }break;
                    case "SendMessage":{
                        PrivateMassage privateMassage = new PrivateMassage();
                        privateMassage.setUser_id_sender(Integer.parseInt(Massage[2]));
                        privateMassage.setUser_id_receiver((Integer.parseInt(Massage[1])));
                        privateMassage.setText(Massage[3]);
                        LocalDate myObj = LocalDate.now(); // Create a date object
                        LocalTime myObj2 = LocalTime.now();
                        String date = myObj.toString() +"^"+myObj2.toString();
                        privateMassage.setDate(date);
                        privateMassageManager.Insert(privateMassage);
                    }break;
                    case "EveryPvsGroups":{
                        int id=Integer.parseInt(Massage[1]);
                        List<User> users = privateMassageManager.RelativeUsers(id);
                        for(User user : users){
                            String Information = "EveryPvsGroups" + "^" + user.getName()+"^"+user.getEmail()+"^"+user.getLastName()+"^"+user.getPassword()+"^"+user.getId()+"^"+user.getProfileAddress()+"^"+user.getUserName();
                            SendMassage(Information);
                        }
                        SendMassage("FinishedPvsGroups");
                    }break;
                    case "ShowMessage":{






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