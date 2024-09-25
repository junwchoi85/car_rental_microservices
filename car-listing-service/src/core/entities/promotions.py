from entities.base_entity import BaseEntity


class Promotions(BaseEntity):

    def __init__(self,
                 promotion_id: int,
                 promotion_code: str,
                 desc: str,
                 discount_rate: float,
                 dt_start: str,
                 dt_end: str,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.promotion_id = promotion_id
        self.promotion_code = promotion_code
        self.desc = desc
        self.discount_rate = discount_rate
        self.dt_start = dt_start
        self.dt_end = dt_end
