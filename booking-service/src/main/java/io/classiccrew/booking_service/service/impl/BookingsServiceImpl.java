package io.classiccrew.booking_service.service.impl;

import org.springframework.stereotype.Service;
import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.entity.Bookings;
import io.classiccrew.booking_service.repository.BookingsRepository;
import io.classiccrew.booking_service.service.IBookingsService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingsServiceImpl implements IBookingsService {
    private BookingsRepository bookingsRepository;

    @Override
    public boolean bookCar(BookingsDto bookingDto) {
        bookingsRepository.save(createNowBookins(bookingDto));
        return true;
    }

    private Bookings createNowBookins(BookingsDto bookingDto) {
        Bookings bookings = new Bookings();
        BookingsMapper.mapToEntity(bookingDto, bookings);
        return bookings;
    }


}
