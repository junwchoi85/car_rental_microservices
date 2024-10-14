package io.classiccrew.car_listing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CarListingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarListingServiceApplication.class, args);
    }

}
