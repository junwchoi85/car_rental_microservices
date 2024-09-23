package io.classiccrew.payment_service.dto;

import lombok.Data;

@Data
public class PaymentsDto {
    private double amount;
    private String paymentDate;
    private String paymentStatus;
    private String transactionId;
}
