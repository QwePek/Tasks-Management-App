package com.tasksmng.taskmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name="boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(name="name", nullable = false)
    private String name;

    public Board() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
