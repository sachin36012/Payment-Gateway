package com.payment.service;

import com.payment.model.CardInfo;
import com.payment.repository.CardInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardInfoService {

    private final CardInfoRepository cardInfoRepository;

    public CardInfoService(CardInfoRepository cardInfoRepository) {
        this.cardInfoRepository = cardInfoRepository;
    }

    public CardInfo createCard(CardInfo cardInfo) {
        return cardInfoRepository.save(cardInfo);
    }

    public List<CardInfo> getAllCards() {
        return cardInfoRepository.findAll();
    }

    public CardInfo getCardById(Long id) {
        return cardInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public CardInfo updateCard(Long id, CardInfo updatedCard) {
        CardInfo existingCard = getCardById(id);
        existingCard.setCardNumber(updatedCard.getCardNumber());
        existingCard.setCardHolderName(updatedCard.getCardHolderName());
        existingCard.setExpiryMonth(updatedCard.getExpiryMonth());
        existingCard.setExpiryYear(updatedCard.getExpiryYear());
        existingCard.setCvv(updatedCard.getCvv());
        return cardInfoRepository.save(existingCard);
    }

    public void deleteCard(Long id) {
        cardInfoRepository.deleteById(id);
    }
}
