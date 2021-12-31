package com.example.boot.service;

import com.example.boot.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void save(User user);

    public void update(User user);

    public void delete(int id);

    public User getUserByName(String name);
}
