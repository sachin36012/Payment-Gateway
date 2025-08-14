package com.payment.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserSubscriptionDto {
    private Long id;
    private UserDto user;
    private CardDto card;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}