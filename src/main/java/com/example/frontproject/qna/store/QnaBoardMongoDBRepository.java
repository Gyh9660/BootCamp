package com.example.frontproject.qna.store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QnaBoardMongoDBRepository extends MongoRepository<QnaBoardDoc,String> {
}
