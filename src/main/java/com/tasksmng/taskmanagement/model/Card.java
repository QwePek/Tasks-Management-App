package com.tasksmng.taskmanagement.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(name="title", nullable = false)
    private String Title;

    @jakarta.persistence.Column(name="description", nullable = false)
    private String Description;

    @jakarta.persistence.Column(name="creation_date", nullable = false)
    private LocalDate CreationDate;

    @jakarta.persistence.Column(name="due_date", nullable = true)
    private LocalDate DueDate;

    @OneToOne
    @JoinColumn(name="column_id", nullable = false)
    private Column column;


    public Card() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }
}
