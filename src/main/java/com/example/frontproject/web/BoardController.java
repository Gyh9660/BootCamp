package com.example.frontproject.web;

import com.example.frontproject.board.domain.entity.Board;
import com.example.frontproject.board.domain.entity.BoardCdo;
import com.example.frontproject.board.domain.logic.BoardLogic;
import com.example.frontproject.web.dto.BoardSaveDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardLogic boardLogic;

    private BoardController(BoardLogic boardLogic){
        this.boardLogic = boardLogic;
    }

    @PutMapping("/board/{no}")
    public void update(@RequestBody BoardSaveDto dto){
        BoardCdo boardCdo = dto.toEntity();

        boardLogic.registerBoard(boardCdo);
    }

    @PostMapping("/board")
    public Board save(@RequestBody BoardSaveDto dto){
        return boardLogic.registerBoard(dto.toEntity());
    }

    @GetMapping("/board/{id}")
    public Board findBoard(@PathVariable String id) {
        return boardLogic.findBoard(id);
    }

    @GetMapping("/board/boardList")
    public List<Board> findBoardList(){
        return boardLogic.findBoardList();
    }

    @DeleteMapping("/board/delete/{id}")
    public void deleteBoardById(@PathVariable String id){
        boardLogic.deleteBoardById(id);
    }
}
