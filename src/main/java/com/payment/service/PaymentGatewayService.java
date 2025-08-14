package com.payment.service;

import com.payment.dto.PaymentGatewayDto;
import com.payment.model.PaymentGateway;
import com.payment.repository.PaymentGatewayRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentGatewayService {

    private final PaymentGatewayRepository gatewayRepository;

    public PaymentGatewayService(PaymentGatewayRepository gatewayRepository) {
        this.gatewayRepository = gatewayRepository;
    }

    public List<PaymentGatewayDto> getAllGateways() {
        return gatewayRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public PaymentGatewayDto createGateway(PaymentGatewayDto dto) {
        PaymentGateway gateway = new PaymentGateway();
        gateway.setName(dto.getName());
        gateway.setDetails(dto.getDetails());
        gatewayRepository.save(gateway);
        return toDto(gateway);
    }

    private PaymentGatewayDto toDto(PaymentGateway gateway) {
        PaymentGatewayDto dto = new PaymentGatewayDto();
        dto.setId(gateway.getId());
        dto.setName(gateway.getName());
        dto.setDetails(gateway.getDetails());
        return dto;
    }
}
