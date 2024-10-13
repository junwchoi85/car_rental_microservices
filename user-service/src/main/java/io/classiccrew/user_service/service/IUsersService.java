package io.classiccrew.user_service.service;

import io.classiccrew.user_service.dto.AppUsersDto;

public interface IUsersService {
    public void createUser(AppUsersDto dto);

    public AppUsersDto getAppUserByEmail(String email);
}
