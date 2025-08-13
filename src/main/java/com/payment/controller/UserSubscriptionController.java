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
import com.payment.model.UserSubscription;
import com.payment.service.UserSubscriptionService;

@RestController
@RequestMapping("/api/user-subscriptions")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    public UserSubscriptionController(UserSubscriptionService userSubscriptionService) {
        this.userSubscriptionService = userSubscriptionService;
    }

    @PostMapping
    public UserSubscription create(@RequestBody UserSubscription userSubscription) {
        return userSubscriptionService.createUserSubscription(userSubscription);
    }

    @GetMapping
    public List<UserSubscription> getAll() {
        return userSubscriptionService.getAllUserSubscriptions();
    }

    @GetMapping("/{id}")
    public UserSubscription getById(@PathVariable Long id) {
        return userSubscriptionService.getUserSubscriptionById(id);
    }

    @PutMapping("/{id}")
    public UserSubscription update(@PathVariable Long id, @RequestBody UserSubscription userSubscription) {
        return userSubscriptionService.updateUserSubscription(id, userSubscription);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userSubscriptionService.deleteUserSubscription(id);
    }
}
