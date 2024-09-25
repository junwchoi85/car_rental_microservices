package io.classiccrew.car_listing_service.service;

import java.util.List;
import io.classiccrew.car_listing_service.dto.CarsDto;

public interface ICarsService {
    List<CarsDto> fetchCarsList();
}
