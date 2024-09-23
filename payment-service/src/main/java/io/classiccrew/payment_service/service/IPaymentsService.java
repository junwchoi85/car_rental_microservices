package io.classiccrew.payment_service.service;

public interface IPaymentsService {

    void createPayment(String entity);

    void fetchPayment(String param);

    void updatePayment(String entity);

    void deletePayment(String entity);
}
