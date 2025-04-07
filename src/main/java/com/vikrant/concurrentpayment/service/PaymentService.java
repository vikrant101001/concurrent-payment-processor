package com.vikrant.concurrentpayment.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    @Async("paymentExecutor")
    public CompletableFuture<String> processPayment(String paymentId) throws InterruptedException {
        System.out.println("Started processing payment: " + paymentId + " on " + Thread.currentThread().getName());
        Thread.sleep(3000); // simulate 3s processing
        System.out.println("Completed processing payment: " + paymentId);
        return CompletableFuture.completedFuture("Payment " + paymentId + " processed");
    }
}
