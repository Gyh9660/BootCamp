package com.example.frontproject.faq.store;


import com.example.frontproject.faq.domain.entity.FaqBoard;

import java.util.List;

public interface FaqBoardStore {
    void save(FaqBoard faqBoard);

    List<FaqBoard> findFaqBoardList();

    FaqBoard findFaqBoard(String id);

    void deleteFaqBoardById(String id);
}
