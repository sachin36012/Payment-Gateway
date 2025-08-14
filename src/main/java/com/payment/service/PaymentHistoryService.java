package com.payment.service;

import com.payment.dto.PaymentHistoryDto;
import com.payment.model.PaymentHistory;
import com.payment.model.Status;
import com.payment.repository.PaymentHistoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryService {

    private final PaymentHistoryRepository historyRepository;

    public PaymentHistoryService(PaymentHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<PaymentHistoryDto> getAllHistories() {
        return historyRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public PaymentHistoryDto createHistory(PaymentHistoryDto dto) {
        PaymentHistory history = new PaymentHistory();
        history.setAmount(dto.getAmount());
        history.setMessage(dto.getMessage());
        history.setStatus(dto.getStatus());
        historyRepository.save(history);
        return toDto(history);
    }

    private PaymentHistoryDto toDto(PaymentHistory history) {
        PaymentHistoryDto dto = new PaymentHistoryDto();
        dto.setId(history.getId());
        dto.setAmount(history.getAmount());
        dto.setMessage(history.getMessage());
        dto.setStatus(history.getStatus());
        return dto;
    }
}
