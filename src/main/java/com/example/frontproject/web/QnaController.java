package com.example.frontproject.web;

import com.example.frontproject.qna.domain.entity.QnaBoard;
import com.example.frontproject.qna.domain.entity.QnaBoardCdo;
import com.example.frontproject.qna.domain.logic.QnaBoardLogic;
import com.example.frontproject.web.dto.QnaSaveDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QnaController {
    private final QnaBoardLogic qnaBoardLogic;

    private QnaController(QnaBoardLogic qnaBoardLogic){
        this.qnaBoardLogic = qnaBoardLogic;
    }

    @PutMapping("/qnaBoard/{no}")
    public void update(@RequestBody QnaSaveDto dto){
        QnaBoardCdo qnaBoardCdo = dto.toEntity();

        qnaBoardLogic.registerQnaBoard(qnaBoardCdo);
    }

    @PostMapping("/qnaBoard")
    public QnaBoard save(@RequestBody QnaSaveDto dto){
        return qnaBoardLogic.registerQnaBoard(dto.toEntity());
    }

    @GetMapping("/qnaBoard/{id}")
    public QnaBoard findQnaBoard(@PathVariable String id) {
        return qnaBoardLogic.findQnaBoard(id);
    }

    @GetMapping("/qnaBoard/qnaBoardList")
    public List<QnaBoard> findQnaBoardList(){
        return qnaBoardLogic.findQnaBoardList();
    }

    @DeleteMapping("/qnaBoard/delete/{id}")
    public void deleteQnaBoardById(@PathVariable String id){
        qnaBoardLogic.deleteQnaBoardById(id);
    }

}
