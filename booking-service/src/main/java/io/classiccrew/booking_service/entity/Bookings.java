package io.classiccrew.booking_service.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.GenericGenerator;
import io.classiccrew.booking_service.dto.VehicleDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long bookingId;
    private Long ausrId;
    // private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    private String bookingCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String pickupBranch;
    private String dropOffBranch;
    private Float totalFee;
    private String status;
}
