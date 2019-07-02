package com.company;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List <User> users = new ArrayList<>();
    private List<Massage> massages = new ArrayList<>();
    private String name;
    private Integer id;

    @Override
    public String toString() {
        return "Group{" +
                "users=" + users +
                ", massages=" + massages +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}