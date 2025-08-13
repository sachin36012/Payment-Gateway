package com.payment.service;

import com.payment.model.UserSubscription;
import com.payment.repository.UserSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSubscriptionService {

    private final UserSubscriptionRepository userSubscriptionRepository;

    public UserSubscriptionService(UserSubscriptionRepository userSubscriptionRepository) {
        this.userSubscriptionRepository = userSubscriptionRepository;
    }

    public UserSubscription createUserSubscription(UserSubscription userSubscription) {
        return userSubscriptionRepository.save(userSubscription);
    }

    public List<UserSubscription> getAllUserSubscriptions() {
        return userSubscriptionRepository.findAll();
    }

    public UserSubscription getUserSubscriptionById(Long id) {
        return userSubscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User subscription not found"));
    }

    public UserSubscription updateUserSubscription(Long id, UserSubscription updatedUserSubscription) {
        UserSubscription existing = getUserSubscriptionById(id);
        existing.setBillingCycle(updatedUserSubscription.getBillingCycle());
        existing.setStartDate(updatedUserSubscription.getStartDate());
        existing.setEndDate(updatedUserSubscription.getEndDate());
        existing.setUser(updatedUserSubscription.getUser());
        existing.setSubscription(updatedUserSubscription.getSubscription());
        return userSubscriptionRepository.save(existing);
    }

    public void deleteUserSubscription(Long id) {
        userSubscriptionRepository.deleteById(id);
    }
}
