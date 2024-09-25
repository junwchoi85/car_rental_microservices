package io.classiccrew.car_listing_service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import io.classiccrew.car_listing_service.dto.CarsDto;
import io.classiccrew.car_listing_service.entity.Cars;

public class CarsMapper {

    public static List<CarsDto> mapToDto(List<Cars> cars) {
        return cars.stream().map(CarsMapper::convertToDto).collect(Collectors.toList());
    }

    private static CarsDto convertToDto(Cars car) {
        return new CarsDto(car.getCarCode(), car.getName(), car.getModelYear(), car.getPassenger(),
                car.getTransmission(), car.getLuggageLarge(), car.getLuggageSmall(),
                car.getEngine(), car.getFuel(), car.getStatus());
    }

    public static CarsDto mapToDto(Cars cars, CarsDto carsDto) {
        carsDto.setCarCode(cars.getCarCode());
        carsDto.setName(cars.getName());
        carsDto.setModelYear(cars.getModelYear());
        carsDto.setPassenger(cars.getPassenger());
        carsDto.setTransmission(cars.getTransmission());
        carsDto.setLuggageLarge(cars.getLuggageLarge());
        carsDto.setLuggageSmall(cars.getLuggageSmall());
        carsDto.setEngine(cars.getEngine());
        carsDto.setFuel(cars.getFuel());
        carsDto.setStatus(cars.getStatus());
        return carsDto;
    }

    public static Cars mapToEntity(CarsDto carsDto, Cars cars) {
        cars.setCarCode(carsDto.getCarCode());
        cars.setName(carsDto.getName());
        cars.setModelYear(carsDto.getModelYear());
        cars.setPassenger(carsDto.getPassenger());
        cars.setTransmission(carsDto.getTransmission());
        cars.setLuggageLarge(carsDto.getLuggageLarge());
        cars.setLuggageSmall(carsDto.getLuggageSmall());
        cars.setEngine(carsDto.getEngine());
        cars.setFuel(carsDto.getFuel());
        cars.setStatus(carsDto.getStatus());
        return cars;
    }
}
