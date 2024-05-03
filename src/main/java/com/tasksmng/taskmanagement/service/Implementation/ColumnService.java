package com.tasksmng.taskmanagement.service.Implementation;

import com.tasksmng.taskmanagement.model.Column;
import com.tasksmng.taskmanagement.repository.ColumnRepository;
import com.tasksmng.taskmanagement.service.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColumnService implements IColumnService {
    @Autowired
    private ColumnRepository columnRepository;

    public List<Column> getAllColumns() {
        return columnRepository.findAll();
    }

    public Optional<Column> getColumnById(Long id) {
        return columnRepository.findById(id);
    }

    public Column createColumn(Column column) {
        return columnRepository.save(column);
    }

    public Column updateColumn(Long id, Column updatedColumn) {
        Optional<Column> existingColumnOptional = columnRepository.findById(id);
        if (existingColumnOptional.isPresent()) {
            Column existingColumn = existingColumnOptional.get();
            existingColumn.setName(updatedColumn.getName());
            // Set other properties as needed
            return columnRepository.save(existingColumn);
        } else {
            throw new IllegalArgumentException("Card with id " + id + " not found.");
        }
    }

    public void deleteColumn(Long id) {
        columnRepository.deleteById(id);
    }
}