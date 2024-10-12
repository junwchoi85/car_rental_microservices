package io.classiccrew.booking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.classiccrew.booking_service.entity.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

}
