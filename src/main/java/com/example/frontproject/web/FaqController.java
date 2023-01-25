package com.example.frontproject.web;

import com.example.frontproject.faq.domain.entity.FaqBoard;
import com.example.frontproject.faq.domain.entity.FaqBoardCdo;
import com.example.frontproject.faq.domain.logic.FaqBoardLogic;
import com.example.frontproject.web.dto.FaqBoardSaveDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FaqController {
    private final FaqBoardLogic faqBoardLogic;

    private FaqController(FaqBoardLogic faqBoardLogic){
        this.faqBoardLogic = faqBoardLogic;
    }

    @PutMapping("/faqBoard/{no}")
    public void update(@RequestBody FaqBoardSaveDto dto){
        FaqBoardCdo faqBoardCdo = dto.toEntity();

        faqBoardLogic.registerFaqBoard(faqBoardCdo);
    }

    @PostMapping("/faqBoard")
    public FaqBoard save(@RequestBody FaqBoardSaveDto dto){
        return faqBoardLogic.registerFaqBoard(dto.toEntity());
    }

    @GetMapping("/faqBoard/{id}")
    public FaqBoard findFaqBoard(@PathVariable String id) {
        return faqBoardLogic.findFaqBoard(id);
    }

    @GetMapping("/faqBoard/faqBoardList")
    public List<FaqBoard> findFaqBoardList(){
        return faqBoardLogic.findFaqBoardList();
    }

    @DeleteMapping("/faqBoard/delete/{id}")
    public void deleteFaqBoardById(@PathVariable String id){
        faqBoardLogic.deleteFaqBoardById(id);
    }
}
