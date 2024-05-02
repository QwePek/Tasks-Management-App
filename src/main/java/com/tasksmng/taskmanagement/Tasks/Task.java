package com.tasksmng.taskmanagement.Tasks;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false)
    private String Title;

    @Column(name="creation_date", nullable = false)
    private LocalDate CreationDate;

    @Column(name="due_date", nullable = true)
    private LocalDate DueDate;

    @Column(name="description", nullable = false)
    private String Description;

    //Klasa musi miec pusty konstruktor dla Hibernate
    public Task() { }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
