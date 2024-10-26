package io.classiccrew.booking_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import io.classiccrew.booking_service.dto.AppUsersDto;

@FeignClient(name = "user-service")
public interface UserServiceFeignClient {

    @GetMapping(value = "/api/fetch-appuser", consumes = "application/json")
    public ResponseEntity<AppUsersDto> fetchAppUser(
            @RequestHeader("correlation-id") String correlationId, @RequestParam String email);
}
