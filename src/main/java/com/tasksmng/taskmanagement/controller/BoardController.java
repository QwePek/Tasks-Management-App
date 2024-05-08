package com.tasksmng.taskmanagement.controller;

import com.tasksmng.taskmanagement.exceptions.ResourceNotFoundException;
import com.tasksmng.taskmanagement.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import com.tasksmng.taskmanagement.service.IBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private IBoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Board board = boardService.getBoardById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Column not found with id: " + id));
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board createdBoard = boardService.createBoard(board);
        return new ResponseEntity<>(createdBoard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board updatedBoard) {
        Board board = boardService.updateBoard(id, updatedBoard);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Board> getBoardByName(@PathVariable String name) {
        Board board = boardService.getBoardByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found with name: " + name));
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/AddBoard")
    public String addTasks() {
        boardService.addBoard(1L);
        return "Board added successfully...";
    }
}
