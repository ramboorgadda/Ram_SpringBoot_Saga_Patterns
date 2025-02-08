package com.rksolutions.paymentservice.service;

import com.rksolutions.commondto.dto.PaymentRequestDTO;
import com.rksolutions.commondto.dto.PaymentResponseDTO;
import com.rksolutions.commondto.enums.PaymentStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private Map<Integer,Double> userBalanceMap;

    @PostConstruct
    private void init(){
        this.userBalanceMap = new HashMap<>();
        userBalanceMap.put(1,1000d);
        userBalanceMap.put(2,1000d);
        userBalanceMap.put(3,1000d);
    }

    public PaymentResponseDTO debit(final PaymentRequestDTO paymentRequestDTO){
        Double balance = this.userBalanceMap.getOrDefault(paymentRequestDTO.getUserId(),0d);

       PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
       paymentResponseDTO.setUserId(paymentRequestDTO.getUserId());
       paymentResponseDTO.setOrderId(paymentRequestDTO.getOrderId());
       paymentResponseDTO.setAmount(paymentRequestDTO.getAmount());
       paymentResponseDTO.setStatus(PaymentStatus.PAYMENT_REJECTED);
       if(balance > paymentRequestDTO.getAmount()){
           paymentResponseDTO.setStatus(PaymentStatus.PAYMENT_APPROVED);
           this.userBalanceMap.put(paymentRequestDTO.getUserId(),balance-paymentRequestDTO.getAmount());
       }
       return paymentResponseDTO;
    }

    public void credit(final PaymentRequestDTO paymentRequestDTO){
        this.userBalanceMap.computeIfPresent(paymentRequestDTO.getUserId(),(k,v)-> v+ paymentRequestDTO.getAmount());
    }
}
