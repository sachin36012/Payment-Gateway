package com.payment.repository;

import com.payment.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
}
