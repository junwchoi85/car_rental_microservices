package io.classiccrew.user_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.user_service.constants.UsersConstants;
import io.classiccrew.user_service.dto.AppUsersDto;
import io.classiccrew.user_service.dto.ResponseDto;
import io.classiccrew.user_service.service.IUsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UsersController {

    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    IUsersService usersService;

    @PostMapping("create-appuser")
    public ResponseEntity<ResponseDto> createAppUser(@RequestBody AppUsersDto dto) {
        usersService.createUser(dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200));
    }

    @GetMapping("fetch-appuser")
    public ResponseEntity<AppUsersDto> fetchAppUser(@RequestParam String email) {
        AppUsersDto appUsersDto = usersService.getAppUserByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(appUsersDto);
    }


    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
