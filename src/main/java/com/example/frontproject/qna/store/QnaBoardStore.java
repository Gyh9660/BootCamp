package com.example.frontproject.qna.store;

import com.example.frontproject.qna.domain.entity.QnaBoard;

import java.util.List;

public interface QnaBoardStore {
    void save(QnaBoard qnaBoard);

    List<QnaBoard> findQnaBoardList();

    QnaBoard findQnaBoard(String id);

    void deleteQnaBoardById(String id);
}