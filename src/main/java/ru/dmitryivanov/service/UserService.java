package ru.dmitryivanov.service;

import ru.dmitryivanov.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
    List<User> listUsers();
    User getUserById(int id);
}
