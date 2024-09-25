package io.classiccrew.car_listing_service.mapper;

import io.classiccrew.car_listing_service.dto.CarRentalTermsDto;
import io.classiccrew.car_listing_service.entity.CarRentalTerms;

public class CarRentalTermsMapper {

    public static CarRentalTermsDto mapToDto(CarRentalTerms carRentalTerms,
            CarRentalTermsDto carRentalTermsDto) {
        carRentalTermsDto.setCarId(carRentalTerms.getCarId());
        carRentalTermsDto.setMinRentPeriod(carRentalTerms.getMinRentPeriod());
        carRentalTermsDto.setMaxRentPeriod(carRentalTerms.getMaxRentPeriod());
        carRentalTermsDto.setPricePerDay(carRentalTerms.getPricePerDay());
        return carRentalTermsDto;
    }

    public static CarRentalTerms mapToEntity(CarRentalTermsDto carRentalTermsDto,
            CarRentalTerms carRentalTerms) {
        carRentalTerms.setCarId(carRentalTermsDto.getCarId());
        carRentalTerms.setMinRentPeriod(carRentalTermsDto.getMinRentPeriod());
        carRentalTerms.setMaxRentPeriod(carRentalTermsDto.getMaxRentPeriod());
        carRentalTerms.setPricePerDay(carRentalTermsDto.getPricePerDay());
        return carRentalTerms;
    }
}
