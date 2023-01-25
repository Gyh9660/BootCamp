package com.example.frontproject.web.dto;

import com.example.frontproject.qna.domain.entity.QnaBoardCdo;
import lombok.Data;

import java.util.Date;

@Data
public class QnaSaveDto {
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public QnaBoardCdo toEntity(){
        QnaBoardCdo qnaBoardCdo = new QnaBoardCdo();
        qnaBoardCdo.setNo(no);
        qnaBoardCdo.setTitle(title);
        qnaBoardCdo.setRegisterDate(registerDate);
        qnaBoardCdo.setContent(content);
        qnaBoardCdo.setUserId(userId);

        return qnaBoardCdo;
    }
}
