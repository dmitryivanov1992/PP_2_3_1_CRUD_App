package ru.dmitryivanov.dao;

import ru.dmitryivanov.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void deleteUser(int id);

    void editUser(User user);

    List<User> listUsers();

    User getUserById(int id);
}
