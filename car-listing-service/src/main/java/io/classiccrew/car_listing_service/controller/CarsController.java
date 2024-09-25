package io.classiccrew.car_listing_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
