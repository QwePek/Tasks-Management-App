package com.tasksmng.taskmanagement.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(name="name", nullable = false)
    private String name;

    @OneToMany(mappedBy="board", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Column> columns = new ArrayList<>();

    public Board() {}

    public Board(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void addColumn(Column column) {
        columns.add(column);
        column.setBoard(this);
    }

    public Column addColumn(String columnName) {
        Column column = new Column(columnName);
        columns.add(column);
        column.setBoard(this);
        return column;
    }

    public void removeColumn(Column column) {
        columns.remove(column);
        column.setBoard(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board )) return false;
        return id != null && id.equals(((Board) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
