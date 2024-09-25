package io.classiccrew.car_listing_service.dto;

import lombok.Data;

@Data
public class PromotionsDto {
    private String promotionCode;
    private String description;
    private double discountRate;
    private String dtStart;
    private String dtEnd;
}
