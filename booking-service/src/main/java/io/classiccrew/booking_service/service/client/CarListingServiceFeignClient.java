package io.classiccrew.booking_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import io.classiccrew.booking_service.dto.VehicleDto;

@FeignClient(name = "car-listing-service")
public interface CarListingServiceFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public ResponseEntity<VehicleDto> fetchVehicleInfoByCode(
            @RequestHeader("correlation-id") String correlationId,
            @RequestParam String vehicleCode);

    @GetMapping("vehicle-info-by-id")
    public ResponseEntity<VehicleDto> fetchVehicleInfoById(@RequestParam String vehicleId);
}
