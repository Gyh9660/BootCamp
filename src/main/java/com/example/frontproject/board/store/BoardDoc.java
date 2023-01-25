package com.example.frontproject.board.store;

import com.example.frontproject.board.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "myCollection")
public class BoardDoc {
    private String id;
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public BoardDoc(Board board){
        super();
        BeanUtils.copyProperties(board,this);
    }

    public Board toDomain(){
        Board board = new Board();
        BeanUtils.copyProperties(this,board);
        return board;
    }

    public static List<Board> toDomains(List<BoardDoc> boardDocs){
        return boardDocs.stream().map(BoardDoc::toDomain).collect(Collectors.toList());
    }


}
