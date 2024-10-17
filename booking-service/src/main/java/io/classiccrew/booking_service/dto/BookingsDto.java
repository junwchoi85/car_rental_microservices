package io.classiccrew.booking_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Bookings")
@Data
public class BookingsDto {
    private String bookingCode;
    private String pickUpBranch;
    private String dropOffBranch;
    private String pickUpDate;
    private String dropOffDate;
    private String pickUpTime;
    private String dropOffTime;
    private String carCode;
    private String userEmail;
    private String vehicleCode;
    private String vehicleName;
}
