package com.example.frontproject.notice.store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeMongoDBRepository extends MongoRepository<NoticeDoc,String> {
}
