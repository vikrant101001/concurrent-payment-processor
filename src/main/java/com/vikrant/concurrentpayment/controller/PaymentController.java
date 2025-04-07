package com.vikrant.concurrentpayment.controller;

import com.vikrant.concurrentpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/process")
    public CompletableFuture<String> processPayment(@RequestParam String paymentId) throws InterruptedException {
        return paymentService.processPayment(paymentId);
    }
}
