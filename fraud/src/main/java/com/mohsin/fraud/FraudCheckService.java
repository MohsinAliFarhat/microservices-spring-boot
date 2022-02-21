package com.mohsin.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    @Autowired
    FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                fraudCheckHistoryRepository.save(
                        FraudCheckHistory.builder()
                                .customerId(customerId)
                                .isFraudster(false)
                                .createdAt(LocalDateTime.now())
                                .build()
        ));
            return false;
    }

}
