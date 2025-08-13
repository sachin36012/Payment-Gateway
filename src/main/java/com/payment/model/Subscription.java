package com.payment.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


/**
 * Represents a subscription plan in the system.
 * This entity is used to define different subscription plans available for users.
 */

@Entity
@Table(name = "subscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "duration_months", nullable = false)
    private Integer durationMonths; // e.g., 1 month, 6 months, 12 months

    @Column(name = "active", nullable = false)
    private Boolean active;
    
    // One subscription can belong to many users
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserSubscription> userSubscriptions;
}

