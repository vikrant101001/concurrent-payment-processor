package com.vikrant.concurrentpayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vikrant.concurrentpayment.model.Payment;
import com.vikrant.concurrentpayment.repository.PaymentRepository;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Async("paymentExecutor")
    public CompletableFuture<String> processPayment(String paymentId) throws InterruptedException {
        paymentRepository.save(new Payment(paymentId, "PENDING"));

        System.out.println("Started processing payment: " + paymentId + " on " + Thread.currentThread().getName());
        Thread.sleep(3000);

        // Simulate success
        Payment payment = paymentRepository.findById(paymentId);
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);

        System.out.println("Completed processing payment: " + paymentId);
        return CompletableFuture.completedFuture("Payment " + paymentId + " processed");
    }

    public Collection<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    

}
