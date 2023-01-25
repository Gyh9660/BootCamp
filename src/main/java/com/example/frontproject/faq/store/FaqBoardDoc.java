package com.example.frontproject.faq.store;

import com.example.frontproject.faq.domain.entity.FaqBoard;
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
@Document(collection = "myFaq")
public class FaqBoardDoc {
    private String id;
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public FaqBoardDoc(FaqBoard faqBoard){
        super();
        BeanUtils.copyProperties(faqBoard,this);
    }

    public FaqBoard toDomain(){
        FaqBoard faqBoard = new FaqBoard();
        BeanUtils.copyProperties(this,faqBoard);
        return faqBoard;
    }

    public static List<FaqBoard> toDomains(List<FaqBoardDoc> faqBoardDocs){
        return faqBoardDocs.stream().map(FaqBoardDoc::toDomain).collect(Collectors.toList());
    }

}
