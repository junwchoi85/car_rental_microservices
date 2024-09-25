from entities.base_entity import BaseEntity


class Customer(BaseEntity):
    def __init__(self,
                 customer_id: int,
                 customer_code: str,
                 username: str,
                 password: str,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.customer_id = customer_id
        self.customer_code = customer_code
        self.username = username
        self.password = password
