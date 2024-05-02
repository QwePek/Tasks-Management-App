package com.tasksmng.taskmanagement.controller;

import com.tasksmng.taskmanagement.model.Board;
import com.tasksmng.taskmanagement.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardRepository.findById(id).orElse(null);
    }
}
