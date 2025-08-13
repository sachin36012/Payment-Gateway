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
import com.payment.model.Subscription;
import com.payment.service.SubscriptionService;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @GetMapping
    public List<Subscription> getAll() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public Subscription getById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PutMapping("/{id}")
    public Subscription update(@PathVariable Long id, @RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(id, subscription);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }
}
