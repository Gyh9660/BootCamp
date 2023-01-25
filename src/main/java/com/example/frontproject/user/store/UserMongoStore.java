package com.example.frontproject.user.store;

import com.example.frontproject.user.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMongoStore implements UserStore {
    private final UserMongoDBRepository userMongoDBRepository;

    public UserMongoStore(UserMongoDBRepository userMongoDBRepository){
        this.userMongoDBRepository =userMongoDBRepository;
    }

    @Override
    public void save(User user){
        UserDoc userDoc = new UserDoc(user);
        userMongoDBRepository.save(userDoc);
    }

    @Override
    public List<User> findUserList(){
        return UserDoc.toDomains(userMongoDBRepository.findAll());
    }

    @Override
    public User findUser(String id){
        return userMongoDBRepository.findById(id).map(UserDoc::toDomain).orElse(null);
    }

    @Override
    public void deleteUserById(String id){
        userMongoDBRepository.deleteById(id);
    }
}
