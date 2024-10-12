package io.classiccrew.car_listing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarListingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarListingServiceApplication.class, args);
    }

}