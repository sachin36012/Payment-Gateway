package com.payment.controller;

import com.payment.dto.SubscriptionDto;
import com.payment.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @PostMapping
    public SubscriptionDto createSubscription(@RequestBody SubscriptionDto dto) {
        return subscriptionService.createSubscription(dto);
    }
}
