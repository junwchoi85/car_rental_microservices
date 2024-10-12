package io.classiccrew.user_service.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import io.classiccrew.user_service.dto.AppUsersDto;

public interface IUsersService {
    public void createUser(AppUsersDto dto);
}
