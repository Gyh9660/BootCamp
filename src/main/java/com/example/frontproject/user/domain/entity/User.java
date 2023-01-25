package com.example.frontproject.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String id;
    private String name;
    private String pass;
    private String userId;

    public User(UserCdo userCdo){
        super();
        BeanUtils.copyProperties(userCdo,this);
    }
}
