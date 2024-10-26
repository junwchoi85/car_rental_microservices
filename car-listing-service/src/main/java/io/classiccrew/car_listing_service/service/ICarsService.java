package io.classiccrew.car_listing_service.service;

import java.util.List;
import io.classiccrew.car_listing_service.dto.CarsDto;
import io.classiccrew.car_listing_service.dto.VehicleDto;

public interface ICarsService {
    List<CarsDto> fetchCarsList();

    List<VehicleDto> fetchVehiclesList();

    public VehicleDto fetchVehicleInfoByCode(String vehicleCode, String correlationId);

    public VehicleDto fetchVehicleInfoById(Long vehicleId);
}
