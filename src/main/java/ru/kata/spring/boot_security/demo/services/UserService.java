package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    void save(User user);

    void removeById(Long id);

    void update(User user, Long id);
}
