package io.classiccrew.payment_service.service;

public interface IPaymentsService {

    void requestPayment(String entity);

    void checkPaymentResult(String param);

    void requestRefund(String entity);

    void getPaymentStatus();
}
