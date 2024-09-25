package io.classiccrew.car_listing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.classiccrew.car_listing_service.entity.CarDetails;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Long> {

}
