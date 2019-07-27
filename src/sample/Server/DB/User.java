package sample.Server.DB;


import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Group> groups = new ArrayList<>();
    private String name;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String profileAddress;
    private Integer id;

    @Override
    public String toString(){
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profileAddress='" + profileAddress + '\'' +
                '}';
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileAddress(String profileAddress) {
        this.profileAddress = profileAddress;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileAddress() {
        return profileAddress;
    }
}