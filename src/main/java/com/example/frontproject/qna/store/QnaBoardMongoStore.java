package com.example.frontproject.qna.store;

import com.example.frontproject.qna.domain.entity.QnaBoard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaBoardMongoStore implements QnaBoardStore{
    private final QnaBoardMongoDBRepository qnaBoardMongoDBRepository;

    public QnaBoardMongoStore(QnaBoardMongoDBRepository qnaBoardMongoDBRepository) {
        this.qnaBoardMongoDBRepository = qnaBoardMongoDBRepository;
    }

    @Override
    public void save(QnaBoard qnaBoard){
        QnaBoardDoc qnaBoardDoc = new QnaBoardDoc(qnaBoard);
        qnaBoardMongoDBRepository.save(qnaBoardDoc);
    }

    @Override
    public List<QnaBoard> findQnaBoardList(){
        return QnaBoardDoc.toDomains(qnaBoardMongoDBRepository.findAll());
    }

    @Override
    public QnaBoard findQnaBoard(String id){
        return qnaBoardMongoDBRepository.findById(id).map(QnaBoardDoc::toDomain).orElse(null);
    }

    @Override
    public void deleteQnaBoardById(String id){
        qnaBoardMongoDBRepository.deleteById(id);
    }
}
