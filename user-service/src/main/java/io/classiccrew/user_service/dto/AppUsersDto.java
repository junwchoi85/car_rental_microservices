package io.classiccrew.user_service.dto;

import lombok.Data;

@Data
public class AppUsersDto {
    private Long ausrId;
    private String email;
    private String username;
    private String password;
}
