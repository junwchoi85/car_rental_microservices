package io.classiccrew.car_listing_service.dto;

import lombok.Data;

@Data
public class CarsDto {
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
