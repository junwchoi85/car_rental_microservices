package io.classiccrew.payment_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payments extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long paymentId;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "transaction_id")
    private String transactionId;
}
