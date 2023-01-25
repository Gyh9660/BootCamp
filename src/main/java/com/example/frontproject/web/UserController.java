package com.example.frontproject.web;

import com.example.frontproject.user.domain.entity.User;
import com.example.frontproject.user.domain.entity.UserCdo;
import com.example.frontproject.user.domain.logic.UserLogic;
import com.example.frontproject.web.dto.UserSaveDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserLogic userLogic;

    private UserController(UserLogic userLogic){
        this.userLogic = userLogic;
    }

    @PutMapping("/user/{userId}")
    public void update(@RequestBody UserSaveDto dto){
        UserCdo userCdo = dto.toEntity();

        userLogic.registerUser(userCdo);
    }

    @PostMapping("/user")
    public User save(@RequestBody UserSaveDto dto){
        return userLogic.registerUser(dto.toEntity());
    }

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable String id) {
        return userLogic.findUser(id);
    }

    @GetMapping("/user/userList")
    public List<User> findUserList(){
        return userLogic.findUserList();
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable String id){
        userLogic.deleteUserById(id);
    }
}
