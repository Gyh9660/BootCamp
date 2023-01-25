package com.example.frontproject.web.dto;

import com.example.frontproject.notice.domain.entity.NoticeCdo;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeSaveDto {
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public NoticeCdo toEntity(){
        NoticeCdo noticeCdo = new NoticeCdo();
        noticeCdo.setNo(no);
        noticeCdo.setTitle(title);
        noticeCdo.setRegisterDate(registerDate);
        noticeCdo.setContent(content);
        noticeCdo.setUserId(userId);

        return noticeCdo;
    }


}
