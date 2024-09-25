package io.classiccrew.car_listing_service.dto;

import lombok.Data;

@Data
public class CarRentalTermsDto {
    private Long carId;
    private int minRentPeriod;
    private int maxRentPeriod;
    private double pricePerDay;
}
