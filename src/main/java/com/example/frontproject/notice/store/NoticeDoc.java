package com.example.frontproject.notice.store;

import com.example.frontproject.notice.domain.entity.Notice;
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
@Document(collection = "myNotice")
public class NoticeDoc {
    private String id;
    private Number no;
    private String title;
    private String content;
    private Date registerDate;
    private String userId;

    public NoticeDoc(Notice notice){
        super();
        BeanUtils.copyProperties(notice,this);
    }

    public Notice toDomain(){
        Notice notice = new Notice();
        BeanUtils.copyProperties(this,notice);
        return notice;
    }

    public static List<Notice> toDomains(List<NoticeDoc> noticeDocs){
        return noticeDocs.stream().map(NoticeDoc::toDomain).collect(Collectors.toList());
    }

}
