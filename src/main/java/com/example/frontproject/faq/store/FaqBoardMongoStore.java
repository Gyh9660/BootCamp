package com.example.frontproject.faq.store;

import com.example.frontproject.faq.domain.entity.FaqBoard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FaqBoardMongoStore implements FaqBoardStore {
    private final FaqBoardMongoDBRepository faqBoardMongoDBRepository;

    public FaqBoardMongoStore(FaqBoardMongoDBRepository faqBoardMongoDBRepository) {
        this.faqBoardMongoDBRepository = faqBoardMongoDBRepository;
    }

    @Override
    public void save(FaqBoard faqBoard){
        FaqBoardDoc faqBoardDoc = new FaqBoardDoc(faqBoard);
        faqBoardMongoDBRepository.save(faqBoardDoc);
    }

    @Override
    public List<FaqBoard> findFaqBoardList(){
        return FaqBoardDoc.toDomains(faqBoardMongoDBRepository.findAll());
    }

    @Override
    public FaqBoard findFaqBoard(String id){
        return faqBoardMongoDBRepository.findById(id).map(FaqBoardDoc::toDomain).orElse(null);
    }

    @Override
    public void deleteFaqBoardById(String id){
        faqBoardMongoDBRepository.deleteById(id);
    }
}
