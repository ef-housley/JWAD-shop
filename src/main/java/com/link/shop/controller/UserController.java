package com.link.shop.controller;

import com.link.shop.model.LoginForm;
import com.link.shop.model.RegisterForm;
import com.link.shop.model.User;
import com.link.shop.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate; // sth like: DriverManager.getConnection()


//  endpoint for returning login.html ->GET

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login.html");
    }

//  endpoint for processing requests from login ->POST

    @PostMapping(value = "/login-result", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postLogin(LoginForm data){
        ModelAndView loginView = new ModelAndView("login.html");

//  check if the user with mentioned email and password exists

        String userQuery = "SELECT * FROM `auto`.`user`WHERE email = '" + data.getEmail()+ "'AND password = '" + data.getPassword()+"'";
        List<User> userList = jdbcTemplate.query(userQuery, new UserRowMapper());

//  if it doesn't print error, else return dashboard.html

        if (userList.size()==0 ){
            loginView.addObject("errLogin", "Incorrect email or password !");
            return loginView;
        }else{
            return new ModelAndView("dashboard.html");
        }

    }

//  endpoint for returning register.html-> GET

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("register.html");
    }

//  endpoint for processing requests from register ->POST

    @PostMapping(value = "/register-result", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postRegister(RegisterForm data){
        ModelAndView registerView = new ModelAndView("register.html");

//  password validation

        if(!data.getPassword().equals(data.getPassword2())){
            registerView.addObject("errPassword", "The passwords do not match");
            return registerView;
        }

//  check if another user with mentioned email exists

        String emailQuery = "SELECT COUNT(*) FROM `auto`.`user` WHERE email ='" + data.getEmail()+"'";
        //->returns a number
        Integer emailCount = jdbcTemplate.queryForObject(emailQuery, Integer.class);
        if (emailCount>0){
            registerView.addObject("errEmail", "The provided email already exists");
            return registerView;
        }


//  add user in database

        String sqlQuery = "INSERT INTO `auto`.`user`(`first_name`,`last_name`,`email`,`password`,`phone`)" +
                "VALUES(?,?,?,?,?);";

        int result = jdbcTemplate.update(sqlQuery, data.getFirstName(), data.getLastName(), data.getEmail(),
                data.getPassword(), data.getPhone());

        return registerView;
    }



}
