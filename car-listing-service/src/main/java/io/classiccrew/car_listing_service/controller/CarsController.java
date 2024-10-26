package io.classiccrew.car_listing_service.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.car_listing_service.dto.CarsDto;
import io.classiccrew.car_listing_service.dto.VehicleDto;
import io.classiccrew.car_listing_service.service.ICarsService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CarsController {
    private static final Logger logger = LoggerFactory.getLogger(CarsController.class);

    private ICarsService iCarsService;

    public CarsController(ICarsService iCarsService) {
        this.iCarsService = iCarsService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarsDto>> fetchCarsList() {
        logger.info("Fetching cars list");
        List<CarsDto> carList = iCarsService.fetchCarsList();
        return ResponseEntity.status(HttpStatus.OK).body(carList);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> fetchVehiclesList() {
        logger.info("Fetching vehicles list");
        List<VehicleDto> vehicleList = iCarsService.fetchVehiclesList();
        return ResponseEntity.status(HttpStatus.OK).body(vehicleList);
    }

    @GetMapping("/fetch")
    public ResponseEntity<VehicleDto> fetchVehicleInfoByCode(
            @RequestHeader("correlation-id") String correlationId,
            @RequestParam String vehicleCode) {
        logger.debug("correlation-id in fetchVehicleInfoByCode: {}", correlationId);
        VehicleDto vehicle = iCarsService.fetchVehicleInfoByCode(vehicleCode, correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @GetMapping("vehicle-info-by-id")
    public ResponseEntity<VehicleDto> fetchVehicleInfoById(@RequestParam String vehicleId) {
        VehicleDto vehicle = iCarsService.fetchVehicleInfoById(Long.valueOf(vehicleId));
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }



    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
