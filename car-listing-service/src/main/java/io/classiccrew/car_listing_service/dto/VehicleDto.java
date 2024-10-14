package io.classiccrew.car_listing_service.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class VehicleDto {

    private Long vehicleId;

    private String vehicleCode;

    private String vehicleName;

    private BigDecimal pricePerDay;
}
