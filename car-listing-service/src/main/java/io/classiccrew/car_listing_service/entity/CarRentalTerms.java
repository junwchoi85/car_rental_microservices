package io.classiccrew.car_listing_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalTerms extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long carRentalTermId;
    private Long carId;
    private int minRentPeriod;
    private int maxRentPeriod;
    private double pricePerDay;
}
