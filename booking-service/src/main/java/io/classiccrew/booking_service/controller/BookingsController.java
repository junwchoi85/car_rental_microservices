package io.classiccrew.booking_service.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.booking_service.constants.BookingsConstants;
import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.dto.ResponseDto;
import io.classiccrew.booking_service.service.IBookingsService;
import io.classiccrew.booking_service.service.client.UserServiceFeignClient;
import jakarta.validation.Valid;



@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class BookingsController {
    private static final Logger logger = LoggerFactory.getLogger(BookingsController.class);

    @Autowired
    private IBookingsService iBookingsService;

    @PostMapping("/book")
    public ResponseEntity<ResponseDto> createBooking(
            @RequestHeader("correlation-id") String correlationId,
            @Valid @RequestBody BookingsDto dto) {

        logger.info("correlation-id in createBooking: {}", correlationId);
        iBookingsService.bookCar(correlationId, dto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(BookingsConstants.STATUS_200, BookingsConstants.MESSAGE_200));

    }

    @GetMapping("/history")
    public ResponseEntity<List<BookingsDto>> fetchBookingHistory(
            @RequestHeader("correlation-id") String correlationId, @RequestParam String email) {
        List<BookingsDto> bookingHistory =
                iBookingsService.fetchBookingHistory(correlationId, email);
        return ResponseEntity.status(HttpStatus.OK).body(bookingHistory);
    }


    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
