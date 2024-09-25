package io.classiccrew.car_listing_service.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import io.classiccrew.car_listing_service.dto.CarsDto;
import io.classiccrew.car_listing_service.entity.Cars;
import io.classiccrew.car_listing_service.mapper.CarsMapper;
import io.classiccrew.car_listing_service.repository.CarsRepository;
import io.classiccrew.car_listing_service.service.ICarsService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements ICarsService {
    private CarsRepository carsRepository;

    @Override
    public List<CarsDto> fetchCarsList() {
        List<Cars> cars = carsRepository.findAll();
        return CarsMapper.mapToDto(cars);
    }
}
