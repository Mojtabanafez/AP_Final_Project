package sample;

import sample.Server.DB.User;

import java.net.Socket;
import java.util.Scanner;

public class LisstenToMassage extends Thread {
    public static Integer pauseForCorrectAnswerInSignIn;
    public static Integer SignInOk;
    User SignIpUser = new User();
    public LisstenToMassage(Socket socket) {
        this.socket = socket;
    }
    static Socket socket;
    @Override
    public void run() {
        try {
            pauseForCorrectAnswerInSignIn = 0;
            SignInOk = 1;
            Scanner socketIn = new Scanner(socket.getInputStream());
            do {
                System.out.println("Listening to Massage...");
                String received = socketIn.nextLine();
                String[] Massage = received.split("\\^");
                switch (Massage[0]) {
                    case "SignIn": {
                        System.out.println("salam");
                        if (Massage[1].equals("not_found_user")) {
                            SignInOk = 0;
                            pauseForCorrectAnswerInSignIn = 1;
                        } else {
                            pauseForCorrectAnswerInSignIn = 1;
                            SignIpUser.setName(Massage[1]);
                            SignIpUser.setEmail(Massage[2]);
                            SignIpUser.setLastName(Massage[3]);
                            SignIpUser.setPassword(Massage[4]);
                            SignIpUser.setId(Integer.parseInt(Massage[5]));
                            SignIpUser.setProfileAddress(Massage[6]);
                            SignIpUser.setUserName(Massage[7]);
                        }
                        pauseForCorrectAnswerInSignIn = 1;
                    }
                    break;
                    default:{
                        System.out.println(Massage[0]);
                        System.out.println("this is default @");
                    }
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}