package com.link.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;
//   TODO: endpoint for returning signIn.html


}
