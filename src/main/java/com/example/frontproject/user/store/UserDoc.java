package com.example.frontproject.user.store;

import com.example.frontproject.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "myUser")
public class UserDoc {
    private String id;
    private String name;
    private String pass;
    private String userId;

    public UserDoc(User user){
        super();
        BeanUtils.copyProperties(user,this);
    }

    public User toDomain(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }

    public static List<User> toDomains(List<UserDoc> userDocs){
        return userDocs.stream().map(UserDoc::toDomain).collect(Collectors.toList());
    }


}
