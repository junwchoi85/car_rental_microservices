package io.classiccrew.car_listing_service.mapper;

import io.classiccrew.car_listing_service.dto.VehicleDto;
import io.classiccrew.car_listing_service.entity.Vehicle;

public class VehicleMapper {
    public static VehicleDto mapToDto(Vehicle vehicle, VehicleDto vehicleDto) {
        vehicleDto.setVehicleId(vehicle.getVehicleId());
        vehicleDto.setVehicleCode(vehicle.getVehicleCode());
        vehicleDto.setVehicleName(vehicle.getVehicleName());
        vehicleDto.setPricePerDay(vehicle.getPricePerDay());
        return vehicleDto;
    }

    public static Vehicle mapToEntity(VehicleDto vehicleDto, Vehicle vehicle) {
        vehicle.setVehicleId(vehicleDto.getVehicleId());
        vehicle.setVehicleCode(vehicleDto.getVehicleCode());
        vehicle.setVehicleName(vehicleDto.getVehicleName());
        vehicle.setPricePerDay(vehicleDto.getPricePerDay());
        return vehicle;
    }

    public static VehicleDto convertToDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        return mapToDto(vehicle, vehicleDto);
    }
}
