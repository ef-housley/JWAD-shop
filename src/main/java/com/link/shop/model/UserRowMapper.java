package com.link.shop.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper <User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();

        user.setUser_id(rs.getInt("user_id"));
        user.setUser_username(rs.getString("user_username"));
        user.setUser_password(rs.getString("user_password"));
        user.setUser_first_name(rs.getString("user_first_name"));
        user.setUser_last_name(rs.getString("user_last_name"));
        user.setUser_email(rs.getString("user_email"));


        return user;
    }

}
