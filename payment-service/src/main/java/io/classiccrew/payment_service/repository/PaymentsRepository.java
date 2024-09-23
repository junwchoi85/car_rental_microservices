package io.classiccrew.payment_service.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import io.classiccrew.payment_service.entity.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {

    Optional<Payments> findByTransactionId(String transactionId);
}
