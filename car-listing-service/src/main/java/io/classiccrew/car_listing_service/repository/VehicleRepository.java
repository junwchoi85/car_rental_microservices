package io.classiccrew.car_listing_service.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.classiccrew.car_listing_service.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByVehicleCode(String vehicleCode);

    Optional<Vehicle> findByVehicleId(Long vehicleId);
}
