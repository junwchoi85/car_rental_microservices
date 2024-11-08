package io.classiccrew.booking_service.service;

import java.util.List;
import io.classiccrew.booking_service.dto.BookingsDto;

public interface IBookingsService {
    boolean bookCar(String correlationId, BookingsDto bookingDto);

    List<BookingsDto> fetchBookingHistory(String correlationId, String email);
}
