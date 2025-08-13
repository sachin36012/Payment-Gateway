package com.payment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.CardInfo;
import com.payment.service.CardInfoService;

@RestController
@RequestMapping("/api/cards")
public class CardInfoController {

    private final CardInfoService cardInfoService;

    public CardInfoController(CardInfoService cardInfoService) {
        this.cardInfoService = cardInfoService;
    }

    @PostMapping
    public CardInfo create(@RequestBody CardInfo cardInfo) {
        return cardInfoService.createCard(cardInfo);
    }

    @GetMapping
    public List<CardInfo> getAll() {
        return cardInfoService.getAllCards();
    }

    @GetMapping("/{id}")
    public CardInfo getById(@PathVariable Long id) {
        return cardInfoService.getCardById(id);
    }

    @PutMapping("/{id}")
    public CardInfo update(@PathVariable Long id, @RequestBody CardInfo cardInfo) {
        return cardInfoService.updateCard(id, cardInfo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cardInfoService.deleteCard(id);
    }
}
