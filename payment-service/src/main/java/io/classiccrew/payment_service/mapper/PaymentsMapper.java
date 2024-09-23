package io.classiccrew.payment_service.mapper;

import io.classiccrew.payment_service.dto.PaymentsDto;
import io.classiccrew.payment_service.entity.Payments;

public class PaymentsMapper {
    public static PaymentsDto mapToPaymentsDto(Payments payments, PaymentsDto paymentsDto) {
        paymentsDto.setAmount(payments.getAmount());
        paymentsDto.setPaymentDate(payments.getPaymentDate());
        paymentsDto.setPaymentStatus(payments.getPaymentStatus());
        paymentsDto.setTransactionId(payments.getTransactionId());
        return paymentsDto;
    }

    public static Payments mapToPayments(PaymentsDto paymentsDto, Payments payments) {
        payments.setAmount(paymentsDto.getAmount());
        payments.setPaymentDate(paymentsDto.getPaymentDate());
        payments.setPaymentStatus(paymentsDto.getPaymentStatus());
        payments.setTransactionId(paymentsDto.getTransactionId());
        return payments;
    }
}
