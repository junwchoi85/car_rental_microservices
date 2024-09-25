from entities.base_entity import BaseEntity


class Roles(BaseEntity):
    def __init__(self,
                 role_id: int,
                 role_code: str,
                 desc: str,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.role_id = role_id
        self.role_code = role_code
        self.desc = desc
