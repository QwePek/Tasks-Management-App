package com.tasksmng.taskmanagement.service;

import com.tasksmng.taskmanagement.model.Column;

import java.util.List;
import java.util.Optional;

public interface IColumnService {

    public List<Column> getAllColumns();
    public Optional<Column> getColumnById(Long id);

    public Column createColumn(Column column);
    public Column updateColumn(Long id, Column updatedColumn);
    public void deleteColumn(Long id);
}
