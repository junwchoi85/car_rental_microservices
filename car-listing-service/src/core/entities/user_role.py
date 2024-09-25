from entities.base_entity import BaseEntity


class UserRole(BaseEntity):
    def __init__(self,
                 uro_id: int,
                 desc: str,
                 user_id: int,
                 role_id: int,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.uro_id = uro_id
        self.desc = desc
        self.user_id = user_id
        self.role_id = role_id
