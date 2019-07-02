package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MassageManager {
    public void Insert(Massage massage){
        try{
            PreparedStatement ps =DBConnector.getConnection().prepareStatement(
              "insert into massage (text,date,user_id) values (?,?,?)");
            ps.setString(1,massage.getText());
            ps.setString(2,massage.getDate());
            ps.setInt(3,massage.getUser().getId());
            ps.execute();
            System.out.println("Inserted@@");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error , can not Inserted!!!!!!!!!");
        }
    }
    public void Delete(int id){
        try{
            PreparedStatement ps = DBConnector.getConnection()
                    .prepareStatement
                            ("delete from massage where id=?");
            ps.setInt(1,id);
            ps.execute();
            System.out.println("Removed");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can't deleted");
        }
    }
    public Massage getMassage(int id){
        Massage result=new Massage();
        try{
            PreparedStatement ps = DBConnector.getConnection().prepareStatement
                    ("select * from massage where id=?");
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            UserManager userManager =new UserManager();
           while (rs.next()){
                result.setId(rs.getInt("id"));
               result.setText(rs.getString("text"));
               result.setDate(rs.getString("date"));
               result.setUser(userManager.getUser(rs.getInt("user_id")));
           }
            ps.execute();
            System.out.println("read from db");
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
        return result;
    }
    public List<Massage> getAllMassage(){
        List<Massage>massages = new ArrayList<>();
        try{
            PreparedStatement ps =DBConnector.getConnection().prepareStatement(
              "select * from massage");
            ResultSet rs = ps.executeQuery();
            UserManager userManager =new UserManager();
            while (rs.next()){
                Massage result = new Massage();
                result.setId(rs.getInt("id"));
                result.setText(rs.getString("text"));
                result.setDate(rs.getString("date"));result.setUser(userManager.getUser(rs.getInt("user_id")));

                massages.add(result);
            }

            ps.execute();
            System.out.println("read list of books from db");
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in representing All of Massage@#$");
        }
        return massages;
    }
    public void Update(Massage newMassage){
        try{
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
              "update massage set text=? , date=? where id=?");

            ps.setString(1,newMassage.getText());
            ps.setString(2,newMassage.getDate());
            ps.setInt(3,newMassage.getId());
            ps.execute();
            System.out.println("updated");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can't updated");
        }
    }
}