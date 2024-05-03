package com.tasksmng.taskmanagement.service.Implementation;

import com.tasksmng.taskmanagement.model.Board;
import com.tasksmng.taskmanagement.repository.BoardRepository;
import com.tasksmng.taskmanagement.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(Long id) {
        return boardRepository.findById(id);
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
        /*Board board1 = new Board("Board 1");
        board1.addColumn(new Column("Column 1"));
        board1.addColumn(new Column("Column 2"));
        board1.getColumns().get(0).addCard(new Card("Card 1"));
        board1.getColumns().get(1).addCard(new Card("Card 2"));
        boardService.createBoard(board1);

        for (int i = 0; i < 50; i++) {
            Task task = new Task();
            task.setTitle("Title " + i);
            task.setCreationDate(LocalDate.now());
            task.setDueDate(LocalDate.now().plusDays(i));
            task.setDescription("Description " + i);
            taskRepository.save(task);
        }*/

    }
}
