package com.example.dilrubareyyan.carsi;

/**
 * Created by dilrubareyyan on 21/09/17.
 */

public class User {

    public String email;
    public String name;
    public String username;
    public String location;
    public String subject;


    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User() {
    }

    //    public User(String email, String name, String username) {
//        this.email = email;
//        this.name = name;
//        this.username = username;
//    }
//
//    public User(String email, String name, String username, String location, String subject) {
//        this.email = email;
//        this.name = name;
//        this.username = username;
//        this.location = location;
//        this.subject = subject;
//
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
