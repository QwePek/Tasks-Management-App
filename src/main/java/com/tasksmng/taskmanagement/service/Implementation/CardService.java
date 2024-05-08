package com.tasksmng.taskmanagement.service.Implementation;


import com.tasksmng.taskmanagement.model.Card;
import com.tasksmng.taskmanagement.repository.CardRepository;
import com.tasksmng.taskmanagement.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public Card updateCard(Long id, Card updatedCard) {
        Optional<Card> existingCardOptional = cardRepository.findById(id);
        if (existingCardOptional.isPresent()) {
            Card existingCard = existingCardOptional.get();
            existingCard.setTitle(updatedCard.getTitle());
            existingCard.setDescription(updatedCard.getDescription());
            existingCard.setDueDate(updatedCard.getDueDate());
            existingCard.setCreationDate(updatedCard.getCreationDate());
            return cardRepository.save(existingCard);
        } else {
            throw new IllegalArgumentException("Card with id " + id + " not found.");
        }
    }
    
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
