package io.classiccrew.user_service.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.user_service.dto.AppUsersDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsersController {
    // @PostMapping("signup")
    // public void postMethodName(@RequestBody UsersDto dto) {
    // // TODO: process POST request

    // return entity;
    // }


    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
