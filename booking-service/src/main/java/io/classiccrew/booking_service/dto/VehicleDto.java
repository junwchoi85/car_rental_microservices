package io.classiccrew.booking_service.dto;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "vehicle")
@Data
public class VehicleDto {

    private Long vehicleId;

    private String vehicleCode;

    private String vehicleName;

    private BigDecimal pricePerDay;
}
