package io.classiccrew.car_listing_service.mapper;

import io.classiccrew.car_listing_service.dto.CarDetailsDto;
import io.classiccrew.car_listing_service.entity.CarDetails;

public class CarDetailsMapper {

    public static CarDetailsDto mapToDto(CarDetails carDetails, CarDetailsDto carDetailsDto) {

        carDetailsDto.setMileage(carDetails.getMileage());
        carDetailsDto.setColor(carDetails.getColor());
        carDetailsDto.setVin(carDetails.getVin());
        carDetailsDto.setStatus(carDetails.getStatus());
        return carDetailsDto;
    }

    public static CarDetails mapToEntity(CarDetailsDto carDetailsDto, CarDetails carDetails) {

        carDetails.setMileage(carDetailsDto.getMileage());
        carDetails.setColor(carDetailsDto.getColor());
        carDetails.setVin(carDetailsDto.getVin());
        carDetails.setStatus(carDetailsDto.getStatus());
        return carDetails;
    }
}
