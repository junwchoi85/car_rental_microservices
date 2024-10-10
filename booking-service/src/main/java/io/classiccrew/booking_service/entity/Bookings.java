package io.classiccrew.booking_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long bookingId;
    private Long customerId;
    private Long carDetailId;
    private String bookingCode;
    private String startDate;
    private String endDate;
    private Float totalFee;
    private String status;
}
