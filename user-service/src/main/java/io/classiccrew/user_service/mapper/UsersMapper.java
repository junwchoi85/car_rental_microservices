package io.classiccrew.user_service.mapper;

import io.classiccrew.user_service.dto.AppUsersDto;
import io.classiccrew.user_service.entity.AppUsers;

public class UsersMapper {
    public static AppUsersDto toUsersDto(AppUsers users, AppUsersDto usersDto) {
        usersDto.setEmail(users.getEmail());
        usersDto.setUsername(users.getUsername());
        usersDto.setPassword(users.getPassword());
        return usersDto;
    }

    public static AppUsers toUsers(AppUsersDto usersDto, AppUsers users) {
        users.setEmail(usersDto.getEmail());
        users.setUsername(usersDto.getUsername());
        users.setPassword(usersDto.getPassword());
        return users;
    }
}
