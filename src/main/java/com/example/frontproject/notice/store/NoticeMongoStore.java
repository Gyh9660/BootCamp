package com.example.frontproject.notice.store;

import com.example.frontproject.notice.domain.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeMongoStore implements NoticeStore {
    private final NoticeMongoDBRepository noticeMongoDBRepository;

    public NoticeMongoStore(NoticeMongoDBRepository noticeMongoDBRepository) {
        this.noticeMongoDBRepository = noticeMongoDBRepository;
    }

    @Override
    public void save(Notice notice){
        NoticeDoc noticeDoc = new NoticeDoc(notice);
        noticeMongoDBRepository.save(noticeDoc);
    }

    @Override
    public List<Notice> findNoticeList(){
        return NoticeDoc.toDomains(noticeMongoDBRepository.findAll());
    }

    @Override
    public Notice findNotice(String id){
        return noticeMongoDBRepository.findById(id).map(NoticeDoc::toDomain).orElse(null);
    }

    @Override
    public void deleteNoticeById(String id){
        noticeMongoDBRepository.deleteById(id);
    }
}
