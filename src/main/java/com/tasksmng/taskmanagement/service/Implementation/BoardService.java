package com.tasksmng.taskmanagement.service.Implementation;

import com.tasksmng.taskmanagement.Utils.HibernateSessionManager;
import com.tasksmng.taskmanagement.model.Board;
import com.tasksmng.taskmanagement.model.Card;
import com.tasksmng.taskmanagement.model.Column;
import com.tasksmng.taskmanagement.repository.BoardRepository;
import com.tasksmng.taskmanagement.repository.CardRepository;
import com.tasksmng.taskmanagement.repository.ColumnRepository;
import com.tasksmng.taskmanagement.service.IBoardService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ColumnRepository columnRepository;
    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public Optional<Board> getBoardByName(String name) {
        return boardRepository.findByName(name);
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board updateBoard(Long id, Board updatedBoard) {
        Optional<Board> existingBoardOptional = boardRepository.findById(id);
        if (existingBoardOptional.isPresent()) {
            Board existingBoard = existingBoardOptional.get();
            existingBoard.setName(updatedBoard.getName());
            // Set other properties as needed

            return boardRepository.save(existingBoard);
        } else {
            throw new IllegalArgumentException("Card with id " + id + " not found.");
        }
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public void addBoard(Long id) {
        Board board = new Board("Board Test");
        board.addColumn(new Column("Column Test 1"));
        board.addColumn(new Column("Column Test 2"));

        board.getColumns().get(0).addCard("Card Test 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(7));
        board.getColumns().get(0).addCard("Card Test 2", "Description 2", LocalDate.now(), LocalDate.now().plusDays(7));
        board.getColumns().get(1).addCard("Card Test 3", "Description 3", LocalDate.now(), LocalDate.now().plusDays(7));
        boardRepository.save(board);
    }
}
