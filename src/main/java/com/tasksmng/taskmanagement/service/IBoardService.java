package com.tasksmng.taskmanagement.service;

import com.tasksmng.taskmanagement.model.Board;

import java.util.List;
import java.util.Optional;

public interface IBoardService {
    public List<Board> getAllBoards();
    public Optional<Board> getBoardById(Long id);

    public Board createBoard(Board board);
    public Board updateBoard(Long id, Board updatedBoard);
    public void deleteBoard(Long id);

    //Debug
    public void addBoard(Long id);
}
