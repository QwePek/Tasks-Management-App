package com.tasksmng.taskmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "columns")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(name="name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="board_id")
    private Board board;

    public Column() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
