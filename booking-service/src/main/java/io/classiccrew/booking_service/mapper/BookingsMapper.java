package io.classiccrew.booking_service.mapper;

import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.entity.Bookings;
import io.classiccrew.booking_service.utils.DateTimeUtil;

public class BookingsMapper {

    public static BookingsDto mapToDto(Bookings bookings, BookingsDto bookingsDto) {
        // bookingsDto.setCustomerId(bookings.getCustomerId());
        // bookingsDto.setCarDetailId(bookings.getCarDetailId());
        // bookingsDto.setBookingCode(bookings.getBookingCode());
        // bookingsDto.setStartDate(bookings.getStartDate());
        // bookingsDto.setEndDate(bookings.getEndDate());
        // bookingsDto.setTotalFee(bookings.getTotalFee());
        // bookingsDto.setStatus(bookings.getStatus());
        return bookingsDto;
    }

    public static Bookings mapToEntity(BookingsDto bookingsDto, Bookings bookings) {
        // bookings.setAusrId(bookingsDto.getAusrId());
        // bookings.setVehicleId(bookingsDto.getVehicleId());
        // bookings.setBookingCode(bookingsDto.getBookingCode());
        bookings.setStartDate(DateTimeUtil.convertToDateTime(bookingsDto.getPickUpDate(),
                bookingsDto.getPickUpTime()));
        bookings.setEndDate(DateTimeUtil.convertToDateTime(bookingsDto.getDropOffDate(),
                bookingsDto.getDropOffTime()));
        // bookings.setTotalFee(bookingsDto.getTotalFee());
        // bookings.setStatus(bookingsDto.getStatus());
        return bookings;
    }

    public static BookingsDto convertToDto(Bookings entity) {
        BookingsDto dto = new BookingsDto();
        dto.setBookingCode(entity.getBookingCode());
        dto.setPickUpBranch(entity.getPickupBranch());
        dto.setDropOffBranch(entity.getDropOffBranch());
        dto.setPickUpDate(DateTimeUtil.convertToLocalDateString(entity.getStartDate()));
        dto.setPickUpTime(DateTimeUtil.convertToLocalTimeString(entity.getStartDate()));
        dto.setDropOffDate(DateTimeUtil.convertToLocalDateString(entity.getEndDate()));
        dto.setDropOffTime(DateTimeUtil.convertToLocalTimeString(entity.getEndDate()));
        dto.setVehicleCode(entity.getVehicle().getVehicleCode());
        dto.setVehicleName(entity.getVehicle().getVehicleName());
        return dto;
    }
}
