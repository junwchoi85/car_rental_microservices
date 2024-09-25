package io.classiccrew.car_listing_service.dto;

import lombok.Data;

@Data
public class CarDetailsDto {
    private Long carId;
    private String mileage;
    private String color;
    private String vin;
    private String status;
}
