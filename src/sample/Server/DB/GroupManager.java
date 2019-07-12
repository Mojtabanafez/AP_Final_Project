package sample.Server.DB;

import sample.Server.DB.DBConnector;
import sample.Server.DB.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupManager {
    public void Insert(Group group){
        try{
        PreparedStatement ps = DBConnector.getConnection().prepareStatement(
          "insert into groups (name) values (?)");
        ps.setString(1,group.getName());
        ps.execute();

        System.out.println("Inserted succeed!!!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Can not inserted!!!");
        }
    }public void Delete(int id){
        try{
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "delete from groups where id=?");
            ps.setInt(1,id);
            ps.execute();
            System.out.println("Removed");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can't deleted");
        }
    }

    public Group getGroup(int  id){
        Group result = new Group();
        try {
            PreparedStatement ps =DBConnector.getConnection().prepareStatement(
                    "select * from  groups where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.setName(rs.getString("name"));
                result.setId(rs.getInt("id"));
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
    public List<Group> getAllGroup(){
        List<Group> groups = new ArrayList<>();
        try{
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
                    "select *from groups");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Group result = new Group();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                groups.add(result);
            }
            ps.execute();
            System.out.println("read list of books from db");
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can not show all of the users");
        }
        return groups;
    }
  //  @ElementCollection
    public void Upadate(Group newGroup){
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(
            "update groups set name=? where id=?");
            ps.setString(1,newGroup.getName());
            ps.setInt(2,newGroup.getId());
            ps.execute();
            System.out.println("updated");
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can't update##");
        }
    }
}