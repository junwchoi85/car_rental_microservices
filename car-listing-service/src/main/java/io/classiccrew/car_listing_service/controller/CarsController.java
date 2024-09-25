package io.classiccrew.car_listing_service.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.car_listing_service.dto.CarsDto;
import io.classiccrew.car_listing_service.service.ICarsService;


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

}
