package com.example.frontproject.user.store;

import com.example.frontproject.user.domain.entity.User;

import java.util.List;

public interface UserStore {

    void save(User user);

    List<User> findUserList();

    User findUser(String id);

    void deleteUserById(String id);
}
