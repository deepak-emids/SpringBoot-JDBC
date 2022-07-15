package com.emids.jdbc.crud.controller;

import com.emids.jdbc.crud.entity.User;
import com.emids.jdbc.crud.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userRepository.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user) {
        return userRepository.updateUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.getById(id);
    }

    @GetMapping()
    public List<User> getUsers() {
        return userRepository.allUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return userRepository.deleteById(id);
    }

}
