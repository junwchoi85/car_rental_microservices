from entities.base_entity import BaseEntity


class Payments(BaseEntity):

    def __init__(self,
                 payment_id: int,
                 booking_id: int,
                 customer_id: int,
                 amount: float,
                 payment_date: str,
                 payment_status: str,
                 transaction_id: str,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.payment_id = payment_id
        self.booking_id = booking_id
        self.customer_id = customer_id
        self.amount = amount
        self.payment_date = payment_date
        self.payment_status = payment_status
        self.transaction_id = transaction_id
