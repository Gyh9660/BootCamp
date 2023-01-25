package com.example.frontproject.qna.domain.logic;

import com.example.frontproject.qna.domain.entity.QnaBoard;
import com.example.frontproject.qna.domain.entity.QnaBoardCdo;
import com.example.frontproject.qna.store.QnaBoardStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QnaBoardLogic {
    private final QnaBoardStore qnaBoardStore;

    public QnaBoardLogic(QnaBoardStore qnaBoardStore){
        this.qnaBoardStore = qnaBoardStore;
    }

    public QnaBoard registerQnaBoard(QnaBoardCdo qnaBoardCdo){
        QnaBoard qnaBoard = new QnaBoard(qnaBoardCdo);
        qnaBoardStore.save(qnaBoard);

        return qnaBoard;
    }

    public QnaBoard findQnaBoard(String id){
        return qnaBoardStore.findQnaBoard(id);
    }

    public List<QnaBoard> findQnaBoardList() {
        return qnaBoardStore.findQnaBoardList();
    }

    public void deleteQnaBoardById(String id){
        qnaBoardStore.deleteQnaBoardById(id);
    }
}
