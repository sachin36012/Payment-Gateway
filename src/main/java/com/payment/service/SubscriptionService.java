package com.payment.service;

import com.payment.model.Subscription;
import com.payment.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public Subscription updateSubscription(Long id, Subscription updatedSubscription) {
        Subscription existingSubscription = getSubscriptionById(id);
        existingSubscription.setPlanName(updatedSubscription.getPlanName());
        existingSubscription.setDescription(updatedSubscription.getDescription());
        existingSubscription.setPrice(updatedSubscription.getPrice());
        existingSubscription.setDurationMonths(updatedSubscription.getDurationMonths());
        existingSubscription.setActive(updatedSubscription.getActive());
        return subscriptionRepository.save(existingSubscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
