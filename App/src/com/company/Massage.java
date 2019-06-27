package com.company;

public class Massage {
    private User user;
    private String text;
    private String date;
    private  Integer id;

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    @Override
    public String toString() {
        return "Massage{" +
                "text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", id=" + id +
                '}';
    }
}