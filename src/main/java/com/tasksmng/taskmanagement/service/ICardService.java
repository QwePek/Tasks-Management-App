package com.tasksmng.taskmanagement.service;

import com.tasksmng.taskmanagement.model.Card;

import java.util.List;
import java.util.Optional;

public interface ICardService {
    public List<Card> getAllCards();
    public Optional<Card> getCardById(Long id);

    public Card createCard(Card card);
    public Card updateCard(Long id, Card updatedCard);
    public void deleteCard(Long id);
}
