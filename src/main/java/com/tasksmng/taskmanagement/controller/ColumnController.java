package com.tasksmng.taskmanagement.controller;

import com.tasksmng.taskmanagement.exceptions.ResourceNotFoundException;
import com.tasksmng.taskmanagement.model.Column;
import com.tasksmng.taskmanagement.service.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/column")
public class ColumnController {
    @Autowired
    private IColumnService columnService;

    @GetMapping
    public ResponseEntity<List<Column>> getAllColumns() {
        List<Column> columns = columnService.getAllColumns();
        return new ResponseEntity<>(columns, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Column> getColumnById(@PathVariable Long id) {
        Column column = columnService.getColumnById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Column not found with id: " + id));
        return new ResponseEntity<>(column, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Column> createColumn(@RequestBody Column column) {
        Column createdColumn = columnService.createColumn(column);
        return new ResponseEntity<>(createdColumn, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Column> updateColumn(@PathVariable Long id, @RequestBody Column updatedColumn) {
        Column column = columnService.updateColumn(id, updatedColumn);
        return new ResponseEntity<>(column, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Column> deleteColumn(@PathVariable Long id) {
        columnService.deleteColumn(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
