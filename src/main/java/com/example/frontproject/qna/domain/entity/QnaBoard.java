package com.example.frontproject.qna.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QnaBoard {
    private String id;
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public QnaBoard(QnaBoardCdo qnaBoardCdo){
        super();
        BeanUtils.copyProperties(qnaBoardCdo,this);
    }
}
