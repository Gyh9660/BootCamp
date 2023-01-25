package com.example.frontproject.notice.store;

import com.example.frontproject.notice.domain.entity.Notice;

import java.util.List;

public interface NoticeStore {
    void save(Notice notice);

    List<Notice> findNoticeList();

    Notice findNotice(String id);

    void deleteNoticeById(String id);
}
