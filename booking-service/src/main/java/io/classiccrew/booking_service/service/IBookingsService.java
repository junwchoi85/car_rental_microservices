package io.classiccrew.booking_service.service;

import io.classiccrew.booking_service.dto.BookingsDto;

public interface IBookingsService {
    boolean bookCar(BookingsDto bookingDto);
}
