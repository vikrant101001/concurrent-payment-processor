package com.vikrant.concurrentpayment.model;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private String status; // e.g., "PENDING", "SUCCESS", "FAILED"
    private LocalDateTime timestamp;

    public Payment(String paymentId, String status) {
        this.paymentId = paymentId;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
