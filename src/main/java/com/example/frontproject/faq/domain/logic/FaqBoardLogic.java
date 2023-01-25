package com.example.frontproject.faq.domain.logic;

import com.example.frontproject.faq.domain.entity.FaqBoard;
import com.example.frontproject.faq.domain.entity.FaqBoardCdo;
import com.example.frontproject.faq.store.FaqBoardStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqBoardLogic {
    private final FaqBoardStore faqBoardStore;

    public FaqBoardLogic(FaqBoardStore faqBoardStore){
        this.faqBoardStore = faqBoardStore;
    }

    public FaqBoard registerFaqBoard(FaqBoardCdo faqBoardCdo){
        FaqBoard faqBoard = new FaqBoard(faqBoardCdo);
        faqBoardStore.save(faqBoard);

        return faqBoard;
    }

    public FaqBoard findFaqBoard(String id){
        return faqBoardStore.findFaqBoard(id);
    }

    public List<FaqBoard> findFaqBoardList() {
        return faqBoardStore.findFaqBoardList();
    }

    public void deleteFaqBoardById(String id){
        faqBoardStore.deleteFaqBoardById(id);
    }
}
