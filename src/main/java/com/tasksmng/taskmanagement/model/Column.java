package com.tasksmng.taskmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "columns")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(name="name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    @JsonIgnore
    private Board board;

    @OneToMany(mappedBy="column",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    public Column() {}

    public Column(String name) {
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
        card.setColumn(this);
    }

    public Card addCard(String title, String description, LocalDate creationDate, LocalDate dueDate) {
        Card card = new Card(title, description, creationDate, dueDate);
        cards.add(card);
        card.setColumn(this);
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Column )) return false;
        return id != null && id.equals(((Column) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
