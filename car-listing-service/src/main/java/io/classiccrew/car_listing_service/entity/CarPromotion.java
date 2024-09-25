package io.classiccrew.car_listing_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarPromotion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long promotionId;
    private String promotionCode;
    private String description;
    private double discountRate;
    private String dtStart;
    private String dtEnd;
}
