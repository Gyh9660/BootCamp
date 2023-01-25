package com.example.frontproject.faq.store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FaqBoardMongoDBRepository extends MongoRepository<FaqBoardDoc, String> {
}
