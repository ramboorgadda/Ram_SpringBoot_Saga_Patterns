package com.rksolutions.paymentservice.controller;

import com.rksolutions.commondto.dto.PaymentRequestDTO;
import com.rksolutions.commondto.dto.PaymentResponseDTO;
import com.rksolutions.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/debit")
    public PaymentResponseDTO debit(@RequestBody PaymentRequestDTO paymentRequestDTO){
        return this.paymentService.debit(paymentRequestDTO);
    }
    @PostMapping("/credit")
    public void credit(@RequestBody PaymentRequestDTO paymentRequestDTO){
           this.paymentService.credit(paymentRequestDTO);
    }
}
