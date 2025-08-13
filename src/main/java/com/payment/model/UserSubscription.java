package com.payment.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 * Represents a user's subscription in the system. This entity is used to manage
 * user subscriptions to different plans.
 */

@Entity
@Table(name = "user_subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Link to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// Link to Subscription
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscription_id", nullable = false)
	private Subscription subscription;

	@Column(name = "billing_cycle", nullable = false)
	private String billingCycle; // e.g., MONTHLY, YEARLY

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;
}
