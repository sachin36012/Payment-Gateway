package com.payment.controller;

import com.payment.dto.CardDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<CardDto> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping
    public CardDto createCard(@RequestBody CardDto dto) {
        return cardService.createCard(dto);
    }
}
