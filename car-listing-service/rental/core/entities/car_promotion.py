from entities.base_entity import BaseEntity


class CarPromotion(BaseEntity):

    def __init__(self,
                 car_promotion_id: int,
                 car_rental_term_id: int,
                 promotion_id: int,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.car_promotion_id = car_promotion_id
        self.car_rental_term_id = car_rental_term_id
        self.promotion_id = promotion_id
