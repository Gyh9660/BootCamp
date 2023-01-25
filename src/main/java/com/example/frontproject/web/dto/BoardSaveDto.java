package com.example.frontproject.web.dto;

import com.example.frontproject.board.domain.entity.BoardCdo;
import lombok.Data;

import java.util.Date;

@Data
public class BoardSaveDto {
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public BoardCdo toEntity(){
        BoardCdo boardCdo = new BoardCdo();
        boardCdo.setNo(no);
        boardCdo.setTitle(title);
        boardCdo.setRegisterDate(registerDate);
        boardCdo.setContent(content);
        boardCdo.setUserId(userId);

        return boardCdo;
    }

}
