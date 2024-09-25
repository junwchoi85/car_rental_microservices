package io.classiccrew.car_listing_service.mapper;

import io.classiccrew.car_listing_service.dto.PromotionsDto;
import io.classiccrew.car_listing_service.entity.Promotions;

public class PromotionsMapper {
    public static PromotionsDto mapToDto(Promotions promotions, PromotionsDto promotionsDto) {
        promotionsDto.setPromotionCode(promotions.getPromotionCode());
        promotionsDto.setDescription(promotions.getDescription());
        promotionsDto.setDiscountRate(promotions.getDiscountRate());
        promotionsDto.setDtStart(promotions.getDtStart());
        promotionsDto.setDtEnd(promotions.getDtEnd());
        return promotionsDto;
    }

    public static Promotions mapToEntity(PromotionsDto promotionsDto, Promotions promotions) {
        promotions.setPromotionCode(promotionsDto.getPromotionCode());
        promotions.setDescription(promotionsDto.getDescription());
        promotions.setDiscountRate(promotionsDto.getDiscountRate());
        promotions.setDtStart(promotionsDto.getDtStart());
        promotions.setDtEnd(promotionsDto.getDtEnd());
        return promotions;
    }
}
