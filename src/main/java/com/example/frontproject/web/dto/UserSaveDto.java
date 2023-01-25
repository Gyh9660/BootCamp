package com.example.frontproject.web.dto;

import com.example.frontproject.user.domain.entity.UserCdo;
import lombok.Data;


@Data
public class UserSaveDto {
    private String name;
    private String pass;
    private String userId;

    public UserCdo toEntity(){
        UserCdo userCdo = new UserCdo();
        userCdo.setName(name);
        userCdo.setPass(pass);
        userCdo.setUserId(userId);

        return userCdo;
    }

}
