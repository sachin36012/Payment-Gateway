package com.payment.controller;

import com.payment.dto.PaymentGatewayDto;
import com.payment.service.PaymentGatewayService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gateways")
public class PaymentGatewayController {

    private final PaymentGatewayService gatewayService;

    public PaymentGatewayController(PaymentGatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @GetMapping
    public List<PaymentGatewayDto> getAllGateways() {
        return gatewayService.getAllGateways();
    }

    @PostMapping
    public PaymentGatewayDto createGateway(@RequestBody PaymentGatewayDto dto) {
        return gatewayService.createGateway(dto);
    }
}
