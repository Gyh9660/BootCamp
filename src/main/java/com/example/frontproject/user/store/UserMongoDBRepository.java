package com.example.frontproject.user.store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoDBRepository extends MongoRepository<UserDoc,String > {

}
