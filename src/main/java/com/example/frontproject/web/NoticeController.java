package com.example.frontproject.web;

import com.example.frontproject.notice.domain.entity.Notice;
import com.example.frontproject.notice.domain.entity.NoticeCdo;
import com.example.frontproject.notice.domain.logic.NoticeLogic;
import com.example.frontproject.web.dto.NoticeSaveDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {
    private final NoticeLogic noticeLogic;

    private NoticeController(NoticeLogic noticeLogic){
        this.noticeLogic = noticeLogic;
    }

    @PutMapping("/notice/{no}")
    public void update(@RequestBody NoticeSaveDto dto){
        NoticeCdo noticeCdo = dto.toEntity();

        noticeLogic.registerNotice(noticeCdo);
    }

    @PostMapping("/notice")
    public Notice save(@RequestBody NoticeSaveDto dto){
        return noticeLogic.registerNotice(dto.toEntity());
    }

    @GetMapping("/notice/{id}")
    public Notice findNotice(@PathVariable String id) {
        return noticeLogic.findNotice(id);
    }

    @GetMapping("/notice/noticeList")
    public List<Notice> findNoticeList(){
        return noticeLogic.findNoticeList();
    }

    @DeleteMapping("/notice/delete/{id}")
    public void deleteNoticeById(@PathVariable String id){
        noticeLogic.deleteNoticeById(id);
    }
}
