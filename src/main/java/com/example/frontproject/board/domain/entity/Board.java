package com.example.frontproject.board.domain.entity;

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

public class Board {
    private String id;
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public Board(BoardCdo boardCdo){
        super();
        BeanUtils.copyProperties(boardCdo,this);
    }
}
