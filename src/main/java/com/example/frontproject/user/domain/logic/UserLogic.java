package com.example.frontproject.user.domain.logic;

import com.example.frontproject.user.domain.entity.User;
import com.example.frontproject.user.domain.entity.UserCdo;
import com.example.frontproject.user.store.UserStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogic {

    private final UserStore userStore;

    public UserLogic(UserStore userStore){
        this.userStore = userStore;
    }

    public User registerUser(UserCdo userCdo){
        User user = new User(userCdo);
        userStore.save(user);

        return user;
    }


    public User findUser(String id){
        return userStore.findUser(id);
    }

    public List<User> findUserList() {
        return userStore.findUserList();
    }

    public void deleteUserById(String id){
        userStore.deleteUserById(id);
    }
}
