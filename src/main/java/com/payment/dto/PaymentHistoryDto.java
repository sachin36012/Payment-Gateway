package com.payment.dto;

import com.payment.model.Status;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentHistoryDto {
    private Long id;
    private BigDecimal amount;
    private String message;
    private Status status;
}