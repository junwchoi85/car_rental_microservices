package io.classiccrew.car_listing_service.entity;

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
public class Cars extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long carId;
    private String carCode;
    private String name;
    private String modelYear;
    private int passenger;
    private String transmission;
    private int luggageLarge;
    private int luggageSmall;
    private String engine;
    private String fuel;
    private String status;
}
