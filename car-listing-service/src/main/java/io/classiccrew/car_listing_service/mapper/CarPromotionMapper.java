package io.classiccrew.car_listing_service.mapper;

import io.classiccrew.car_listing_service.dto.CarPromotionDto;
import io.classiccrew.car_listing_service.entity.CarPromotion;

public class CarPromotionMapper {

    public static CarPromotionDto mapToDto(CarPromotion carPromotion,
            CarPromotionDto carPromotionDto) {

        carPromotionDto.setPromotionCode(carPromotion.getPromotionCode());
        carPromotionDto.setDescription(carPromotion.getDescription());
        carPromotionDto.setDiscountRate(carPromotion.getDiscountRate());
        carPromotionDto.setDtStart(carPromotion.getDtStart());
        carPromotionDto.setDtEnd(carPromotion.getDtEnd());
        return carPromotionDto;
    }

    public static CarPromotion mapToEntity(CarPromotionDto carPromotionDto,
            CarPromotion carPromotion) {

        carPromotion.setPromotionCode(carPromotionDto.getPromotionCode());
        carPromotion.setDescription(carPromotionDto.getDescription());
        carPromotion.setDiscountRate(carPromotionDto.getDiscountRate());
        carPromotion.setDtStart(carPromotionDto.getDtStart());
        carPromotion.setDtEnd(carPromotionDto.getDtEnd());
        return carPromotion;
    }
}
