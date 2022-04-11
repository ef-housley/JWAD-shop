package com.link.shop.model;

import java.util.Date;

public class User {
    private Integer user_id;
    private String user_username;
    private String user_first_name;
    private String user_last_name;
    private String user_email;
    private String user_password;
    private Enum user_occupation;
    private Date user_joined;


    public User(Integer user_id, String user_username, String user_first_name, String user_last_name, String user_email, String user_password, Enum user_occupation, Date user_joined) {
        this.user_id = user_id;
        this.user_username = user_username;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_occupation = user_occupation;
        this.user_joined = user_joined;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Enum getUser_occupation() {
        return user_occupation;
    }

    public void setUser_occupation(Enum user_occupation) {
        this.user_occupation = user_occupation;
    }

    public Date getUser_joined() {
        return user_joined;
    }

    public void setUser_joined(Date user_joined) {
        this.user_joined = user_joined;
    }
}

