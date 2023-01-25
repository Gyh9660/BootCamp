package com.example.frontproject.board.store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardMongoDBRepository extends MongoRepository<BoardDoc, String> {

}
