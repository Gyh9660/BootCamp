package com.example.frontproject.qna.store;

import com.example.frontproject.qna.domain.entity.QnaBoard;
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
@Document(collection = "myQna")
public class QnaBoardDoc {
    private String id;
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public QnaBoardDoc(QnaBoard qnaBoard){
        super();
        BeanUtils.copyProperties(qnaBoard,this);
    }

    public QnaBoard toDomain(){
        QnaBoard qnaBoard = new QnaBoard();
        BeanUtils.copyProperties(this,qnaBoard);
        return qnaBoard;
    }

    public static List<QnaBoard> toDomains(List<QnaBoardDoc> qnaBoardDocs){
        return qnaBoardDocs.stream().map(QnaBoardDoc::toDomain).collect(Collectors.toList());
    }

}
