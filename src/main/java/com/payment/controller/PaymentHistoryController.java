package com.payment.controller;

import com.payment.dto.PaymentHistoryDto;
import com.payment.service.PaymentHistoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class PaymentHistoryController {

    private final PaymentHistoryService historyService;

    public PaymentHistoryController(PaymentHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<PaymentHistoryDto> getAllHistories() {
        return historyService.getAllHistories();
    }

    @PostMapping
    public PaymentHistoryDto createHistory(@RequestBody PaymentHistoryDto dto) {
        return historyService.createHistory(dto);
    }
}
