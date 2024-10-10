package io.classiccrew.booking_service.service.impl;

import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.entity.Bookings;

public class BookingsMapper {
    public static BookingsDto mapToDto(Bookings bookings, BookingsDto bookingsDto) {
        bookingsDto.setCustomerId(bookings.getCustomerId());
        bookingsDto.setCarDetailId(bookings.getCarDetailId());
        bookingsDto.setBookingCode(bookings.getBookingCode());
        bookingsDto.setStartDate(bookings.getStartDate());
        bookingsDto.setEndDate(bookings.getEndDate());
        bookingsDto.setTotalFee(bookings.getTotalFee());
        bookingsDto.setStatus(bookings.getStatus());
        return bookingsDto;
    }

    public static Bookings mapToEntity(BookingsDto bookingsDto, Bookings bookings) {
        bookings.setCustomerId(bookingsDto.getCustomerId());
        bookings.setCarDetailId(bookingsDto.getCarDetailId());
        bookings.setBookingCode(bookingsDto.getBookingCode());
        bookings.setStartDate(bookingsDto.getStartDate());
        bookings.setEndDate(bookingsDto.getEndDate());
        bookings.setTotalFee(bookingsDto.getTotalFee());
        bookings.setStatus(bookingsDto.getStatus());
        return bookings;
    }
}
