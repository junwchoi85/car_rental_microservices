package io.classiccrew.booking_service.dto;

import lombok.Data;

@Data
public class AppUsersDto {
    private String email;
    private String username;
    private String password;
}
