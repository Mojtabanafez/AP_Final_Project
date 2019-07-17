package sample.Server.DB;

import sample.Server.DB.DBConnector;
import sample.Server.DB.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    public void Insert(User user){
        try{
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "insert into users (name, lastname, email, username, password, profileAddress) values(?,?,?,?,?,?)");
                ps.setString(1,user.getName());
                ps.setString(2,user.getLastName());
                ps.setString(3,user.getEmail());
                ps.setString(4,user.getUserName());
                ps.setString(5,user.getPassword());
                ps.setString(6,user.getProfileAddress());
                ps.execute();
            System.out.println("Inserted succeed!!!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Can not inserted!!!");
        }
    }
    public void Delete(int id){
        try{
            PreparedStatement ps = DBConnector.getConnection()
                    .prepareStatement
                            ("delete from users where id=?");
            ps.setInt(1,id);
            ps.execute();
            System.out.println("Removed");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can't deleted");
        }
    }
    public  User getUser(String password,String userName){
    User result= new User();
        try {
        PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                "select * from  ap_final_project.public.users where (password=? AND username=? )");
        ps.setString(1,password);
        ps.setString(2,userName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result.setId(rs.getInt(("id")));
            result.setName(rs.getString("name"));
            result.setLastName(rs.getString("lastName"));
            result.setEmail(rs.getString("email"));
            result.setPassword(rs.getString("password"));
            result.setUserName(rs.getString("userName"));
            result.setProfileAddress(rs.getString("profileAddress"));
        }
        ps.execute();
        System.out.println("read from DB");
        rs.close();
        ps.close();

    }catch (Exception e){
        e.printStackTrace();
        System.out.println("can not find user or failed in this way!!!!");
    }
        return result;
}

    public  User getUser(String userName){
        User result= new User();
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "select * from  ap_final_project.public.users where username=? ");
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.setId(rs.getInt(("id")));
                result.setName(rs.getString("name"));
                result.setLastName(rs.getString("lastName"));
                result.setEmail(rs.getString("email"));
                result.setPassword(rs.getString("password"));
                result.setUserName(rs.getString("userName"));
                result.setProfileAddress(rs.getString("profileAddress"));
            }
            ps.execute();
            System.out.println("read from DB");
            rs.close();
            ps.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can not find user or failed in this way!!!!");
        }
        return result;
    }
    public User getUser(int id){

        User result= new User();
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "select * from  ap_final_project.public.users where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.setId(rs.getInt(("id")));
                result.setName(rs.getString("name"));
                result.setLastName(rs.getString("lastName"));
                result.setEmail(rs.getString("email"));
                result.setPassword(rs.getString("password"));
                result.setUserName(rs.getString("userName"));
                result.setProfileAddress(rs.getString("profileAddress"));
            }
            ps.execute();
            System.out.println("read from DB");
            rs.close();
            ps.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can not find user or failed in this way!!!!");
        }
        return result;
    }
    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        try{
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
              "select *from ap_final_project.public.users"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User result = new User();
                result.setId(rs.getInt(("id")));
                result.setPassword(rs.getString("password"));
                result.setName(rs.getString("name"));
                result.setLastName(rs.getString("lastName"));
                result.setEmail(rs.getString("email"));
                result.setUserName(rs.getString("userName"));
                result.setProfileAddress(rs.getString("profileAddress"));
                users.add(result);
            }
            ps.execute();
            System.out.println("read list of books from db");
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can not show all of the users");
        }
        return users;
    }
    public void Update(User newUser){
        try{

            PreparedStatement ps =DBConnector.getConnection().prepareStatement(
                    "update users set name=? , lastName=? , email=? , userName=? , password=? , profileADDress=? where id=?");
            ps.setString(1,newUser.getName());
            ps.setString(2,newUser.getLastName());
            ps.setString(3,newUser.getEmail());
            ps.setString(4,newUser.getUserName());
            ps.setString(5,newUser.getPassword());
            ps.setString(6,newUser.getProfileAddress());
            ps.setInt(7,newUser.getId());
            ps.execute();
            System.out.println("updated");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can't update##");
        }
    }
}