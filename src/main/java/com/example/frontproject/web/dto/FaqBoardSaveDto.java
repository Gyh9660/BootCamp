package com.example.frontproject.web.dto;

import com.example.frontproject.faq.domain.entity.FaqBoardCdo;
import lombok.Data;

import java.util.Date;

@Data
public class FaqBoardSaveDto {
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public FaqBoardCdo toEntity(){
        FaqBoardCdo faqBoardCdo = new FaqBoardCdo();
        faqBoardCdo.setNo(no);
        faqBoardCdo.setTitle(title);
        faqBoardCdo.setRegisterDate(registerDate);
        faqBoardCdo.setContent(content);
        faqBoardCdo.setUserId(userId);

        return faqBoardCdo;
    }

}
