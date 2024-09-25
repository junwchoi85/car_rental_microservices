from entities.base_entity import BaseEntity


class Users(BaseEntity):
    def __init__(self,
                 user_id: int,
                 user_code: str,
                 username: str,
                 password: str,
                 created_at=None, created_by=None, updated_at=None, updated_by=None):

        super().__init__(created_at, created_by, updated_at, updated_by)

        self.user_id = user_id
        self.user_code = user_code
        self.username = username
        self.password = password
