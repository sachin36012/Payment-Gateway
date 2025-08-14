package com.payment.controller;

import com.payment.dto.UserSubscriptionDto;
import com.payment.service.UserSubscriptionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-subscriptions")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubService;

    public UserSubscriptionController(UserSubscriptionService userSubService) {
        this.userSubService = userSubService;
    }

    @GetMapping
    public List<UserSubscriptionDto> getAllUserSubscriptions() {
        return userSubService.getAllUserSubscriptions();
    }

    @PostMapping
    public UserSubscriptionDto createUserSubscription(@RequestBody UserSubscriptionDto dto) {
        return userSubService.createUserSubscription(dto);
    }
}
