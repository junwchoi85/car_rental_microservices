package io.classiccrew.car_listing_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import io.classiccrew.car_listing_service.dto.CarsDto;
import io.classiccrew.car_listing_service.dto.VehicleDto;
import io.classiccrew.car_listing_service.entity.Cars;
import io.classiccrew.car_listing_service.entity.Vehicle;
import io.classiccrew.car_listing_service.exception.ResourceNotFoundException;
import io.classiccrew.car_listing_service.mapper.CarsMapper;
import io.classiccrew.car_listing_service.mapper.VehicleMapper;
import io.classiccrew.car_listing_service.repository.CarsRepository;
import io.classiccrew.car_listing_service.repository.VehicleRepository;
import io.classiccrew.car_listing_service.service.ICarsService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements ICarsService {
    private CarsRepository carsRepository;
    private VehicleRepository vehicleRepository;

    @Override
    public List<CarsDto> fetchCarsList() {
        List<Cars> cars = carsRepository.findAll();
        return CarsMapper.mapToDto(cars);
    }

    @Override
    public List<VehicleDto> fetchVehiclesList() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList.stream().map(VehicleMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public VehicleDto fetchVehicleInfoByCode(String vehicleCode, String correlationId) {
        Vehicle vehicle = vehicleRepository.findByVehicleCode(vehicleCode).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "vehicleCode", vehicleCode));
        return VehicleMapper.mapToDto(vehicle, new VehicleDto());
    }

    @Override
    public VehicleDto fetchVehicleInfoById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "vehicleId",
                        String.valueOf(vehicleId)));
        return VehicleMapper.mapToDto(vehicle, new VehicleDto());
    }


}
