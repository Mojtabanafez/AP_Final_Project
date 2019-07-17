package sample.Server.DB;

import javafx.scene.control.ScrollPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrivateMassageManager {
    public static void main(String[] args) {
        PrivateMassageManager privateMassageManager = new PrivateMassageManager();
        PrivateMassage privateMassage = new PrivateMassage();
        privateMassage.setUser_id_sender(24);
        privateMassage.setUser_id_receiver(23);
        privateMassage.setDate("1396/asfd3404/12");
        privateMassage.setText("nasdfawerwerewrtrfez");
        privateMassage.setId(7);
        List<User> a = privateMassageManager.RelativeUsers(23);
        System.out.println(a);
        //System.out.println(privateMassageManager.getMassage(7));
        //   privateMassageManager.Update(privateMassage);
        //       privateMassageManager.Delete(5);
        //   privateMassageManager.Insert(privateMassage);
        //     List<PrivateMassage> list= privateMassageManager.getAllReceivedMassage(23);
        //   for(PrivateMassage a:list)
        //     System.out.println(a);

    }

    public List<User> RelativeUsers(int accountOwnerId) {
        List<Integer> result = new ArrayList<>();
        List<User>users = new ArrayList<>();
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement
                    ("select * from privatemassage where user_id_receiver=?");
            ps.setInt(1, accountOwnerId);
            ResultSet rs = ps.executeQuery();
            UserManager userManager = new UserManager();
            while (rs.next()) {
                result.add(rs.getInt("user_id_sender"));
            }
            ps.execute();
            PreparedStatement ps2 = DBConnector.getConnection().prepareStatement
                    ("select * from privatemassage where user_id_sender=?");
            ps2.setInt(1, accountOwnerId);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                result.add(rs2.getInt("user_id_receiver"));
            }
            ps2.execute();
            System.out.println("read from db");
            rs.close();
            ps.close();

            result = result.stream().distinct().collect(Collectors.toList());

            for(int tmp : result)
                users.add(userManager.getUser(tmp));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }

        return users;
    }

    public void Insert(PrivateMassage privateMassage) {
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement("insert into privatemassage (text,date,user_id_sender,user_id_receiver) values (?,?,?,?)");
            ps.setString(1, privateMassage.getText());
            ps.setString(2, privateMassage.getDate());
            ps.setInt(3, privateMassage.getUser_id_sender());
            ps.setInt(4, privateMassage.getUser_id_receiver());
            ps.execute();
            System.out.println("Inserted@@");
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error , can not Inserted!!!!!!!!!");
        }
    }


    public void Delete(int id) {
        try {
            PreparedStatement ps = DBConnector.getConnection()
                    .prepareStatement
                            ("delete from privatemassage where id=?");
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Removed");
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("can't deleted");
        }
    }

    public List<PrivateMassage> getAllReceivedMassage(int user_id_receiver) {
        List<PrivateMassage> privateMassages = new ArrayList<>();

        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "select * from privatemassage where  user_id_receiver=?");
            ps.setInt(1, user_id_receiver);
            ResultSet rs = ps.executeQuery();
            UserManager userManager = new UserManager();
            while (rs.next()) {
                PrivateMassage result = new PrivateMassage();
                result.setId(rs.getInt("id"));
                result.setText(rs.getString("text"));

                result.setDate(rs.getString("date"));
                result.setUser_id_receiver((rs.getInt("user_id_receiver")));
                result.setUser_id_sender(rs.getInt("user_id_sender"));
                privateMassages.add(result);
            }
            ps.execute();
            System.out.println("read list of books from db");
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in representing All of PrivateMassage@#$");
        }
        return privateMassages;
    }

    public PrivateMassage getMassage(int id) {
        PrivateMassage result = new PrivateMassage();
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement
                    ("select * from privatemassage where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            UserManager userManager = new UserManager();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setText(rs.getString("text"));
                result.setDate(rs.getString("date"));
                result.setUser_id_receiver(rs.getInt(("user_id_receiver")));
                result.setUser_id_sender(rs.getInt("user_id_sender"));
            }
            ps.execute();
            System.out.println("read from db");
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return result;
    }

    public void Update(PrivateMassage newPrivateMassage) {
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "update privatemassage set text=? , date=? where id=?");

            ps.setString(1, newPrivateMassage.getText());
            ps.setString(2, newPrivateMassage.getDate());
            ps.setInt(3, newPrivateMassage.getId());
            ps.execute();
            System.out.println("updated");
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("can't updated");
        }
    }
}