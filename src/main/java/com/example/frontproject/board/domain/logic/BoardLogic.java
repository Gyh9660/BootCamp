package com.example.frontproject.board.domain.logic;

import com.example.frontproject.board.domain.entity.Board;
import com.example.frontproject.board.domain.entity.BoardCdo;
import com.example.frontproject.board.store.BoardStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BoardLogic {

    private final BoardStore boardStore;

    public BoardLogic(BoardStore boardStore){
        this.boardStore = boardStore;
    }

    public Board registerBoard(BoardCdo boardCdo){
        Board board = new Board(boardCdo);
        board.setId(UUID.randomUUID().toString());
        boardStore.save(board);

        return board;
    }

    public Board findBoard(String id){
        return boardStore.findBoard(id);
    }

    public List<Board> findBoardList() {
        return boardStore.findBoardList();
    }

    public void deleteBoardById(String id){
        boardStore.deleteBoardById(id);
    }
}
