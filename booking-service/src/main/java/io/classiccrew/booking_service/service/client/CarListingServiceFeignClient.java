package io.classiccrew.booking_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.classiccrew.booking_service.dto.VehicleDto;

@FeignClient(name = "car-listing-service")
public interface CarListingServiceFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public ResponseEntity<VehicleDto> fetchCarInfo(@RequestParam String vehicleCode);
}
