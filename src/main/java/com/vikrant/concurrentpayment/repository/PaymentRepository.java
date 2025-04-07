package com.vikrant.concurrentpayment.repository;

import com.vikrant.concurrentpayment.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PaymentRepository {
    private final ConcurrentHashMap<String, Payment> storage = new ConcurrentHashMap<>();

    public void save(Payment payment) {
        storage.put(payment.getPaymentId(), payment);
    }

    public Payment findById(String paymentId) {
        return storage.get(paymentId);
    }

    public Collection<Payment> findAll() {
        return storage.values();
    }
}
