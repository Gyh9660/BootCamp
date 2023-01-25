package com.example.frontproject.notice.domain.logic;

import com.example.frontproject.notice.domain.entity.Notice;
import com.example.frontproject.notice.domain.entity.NoticeCdo;
import com.example.frontproject.notice.store.NoticeStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeLogic {
    private final NoticeStore noticeStore;

    public NoticeLogic(NoticeStore noticeStore){
        this.noticeStore = noticeStore;
    }

    public Notice registerNotice(NoticeCdo noticeCdo){
        Notice notice = new Notice(noticeCdo);
        noticeStore.save(notice);

        return notice;
    }

    public Notice findNotice(String id){
        return noticeStore.findNotice(id);
    }

    public List<Notice> findNoticeList() {
        return noticeStore.findNoticeList();
    }

    public void deleteNoticeById(String id){
        noticeStore.deleteNoticeById(id);
    }

}
