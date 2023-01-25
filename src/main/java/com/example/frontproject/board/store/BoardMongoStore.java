package com.example.frontproject.board.store;

import com.example.frontproject.board.domain.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardMongoStore implements BoardStore {
    private final BoardMongoDBRepository boardMongoDBRepository;

    public BoardMongoStore(BoardMongoDBRepository boardMongoDBRepository){
        this.boardMongoDBRepository =boardMongoDBRepository;
    }

    @Override
    public void save(Board board){
        BoardDoc boardDoc = new BoardDoc(board);
        boardMongoDBRepository.save(boardDoc);
    }

    @Override
    public List<Board> findBoardList(){
        return BoardDoc.toDomains(boardMongoDBRepository.findAll());
    }

    @Override
    public Board findBoard(String id){
        return boardMongoDBRepository.findById(id).map(BoardDoc::toDomain).orElse(null);
    }

    @Override
    public void deleteBoardById(String id){
        boardMongoDBRepository.deleteById(id);
    }
}
