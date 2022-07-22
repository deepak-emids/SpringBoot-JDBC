package com.emids.jdbc.crud.dao;

import com.emids.jdbc.crud.entity.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);

    List<User> allUsers();

    User getById(int id);

    User updateUser(User user);
    
    String deleteById(int id);


}
