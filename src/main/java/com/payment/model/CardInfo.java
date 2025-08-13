package com.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents card information for payment processing.
 * This entity is used to store card details securely.
 */

@Entity
@Table(name = "card_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "card_number", nullable = false, length = 16)
	private String cardNumber;

	@Column(name = "card_holder_name", nullable = false)
	private String cardHolderName;

	@Column(name = "expiry_month", nullable = false, length = 2)
	private String expiryMonth;

	@Column(name = "expiry_year", nullable = false, length = 4)
	private String expiryYear;

	@Column(name = "cvv", nullable = false, length = 4)
	private String cvv;
	
	// Many cards belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;
}
