package io.classiccrew.booking_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Bookings")
@Data
public class BookingsDto {
    private Long customerId;
    private Long carDetailId;
    private String bookingCode;
    private String startDate;
    private String endDate;
    private Float totalFee;
    private String status;
}
