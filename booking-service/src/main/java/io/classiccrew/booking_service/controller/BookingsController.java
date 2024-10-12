package io.classiccrew.booking_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.booking_service.constants.BookingsConstants;
import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.dto.ResponseDto;
import io.classiccrew.booking_service.service.IBookingsService;
import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class BookingsController {
    private static final Logger logger = LoggerFactory.getLogger(BookingsController.class);

    @Autowired
    private IBookingsService iBookingsService;

    @PostMapping("/book")
    public ResponseEntity<ResponseDto> postMethodName(@Valid @RequestBody BookingsDto dto) {
        iBookingsService.bookCar(dto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(BookingsConstants.STATUS_200, BookingsConstants.MESSAGE_200));

    }

}
