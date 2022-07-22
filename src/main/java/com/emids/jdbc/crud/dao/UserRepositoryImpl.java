package com.emids.jdbc.crud.dao;

import com.emids.jdbc.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO USER(id,fname,lname,email) values(?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET fname=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFname(), user.getLname(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFname(), user.getId());
        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "User got deleted with id " + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, BeanPropertyRowMapper.newInstance(User.class));
    }
}
