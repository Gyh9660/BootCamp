package com.example.frontproject.board.store;

import com.example.frontproject.board.domain.entity.Board;

import java.util.List;

public interface BoardStore {

    void save(Board board);

    List<Board> findBoardList();

    Board findBoard(String id);

    void deleteBoardById(String id);
}
