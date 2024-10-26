package io.classiccrew.booking_service.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.classiccrew.booking_service.dto.AppUsersDto;
import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.dto.VehicleDto;
import io.classiccrew.booking_service.entity.Bookings;
import io.classiccrew.booking_service.entity.Vehicle;
import io.classiccrew.booking_service.mapper.BookingsMapper;
import io.classiccrew.booking_service.mapper.VehicleMapper;
import io.classiccrew.booking_service.repository.BookingsRepository;
import io.classiccrew.booking_service.service.IBookingsService;
import io.classiccrew.booking_service.service.client.CarListingServiceFeignClient;
import io.classiccrew.booking_service.service.client.UserServiceFeignClient;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingsServiceImpl implements IBookingsService {
    private BookingsRepository bookingsRepository;
    private UserServiceFeignClient userServiceFeignClient;
    private CarListingServiceFeignClient carServiceFeignClient;

    @Override
    public boolean bookCar(String correlationId, BookingsDto bookingDto) {
        Bookings bookings = new Bookings();

        // Fetch user details
        String userEmail = bookingDto.getUserEmail();
        ResponseEntity<AppUsersDto> appUserDto =
                userServiceFeignClient.fetchAppUser(correlationId, userEmail);
        if (appUserDto == null || appUserDto.getBody() == null) {
            return false;
        }
        Long asurId = appUserDto.getBody().getAusrId();
        bookings.setAusrId(asurId);

        // Fetch Vehicle details
        String vehicleCode = bookingDto.getVehicleCode();
        ResponseEntity<VehicleDto> vehicleDto =
                carServiceFeignClient.fetchVehicleInfoByCode(correlationId, vehicleCode);
        if (vehicleDto == null || vehicleDto.getBody() == null) {
            return false;
        }

        VehicleDto vehicleDetails = vehicleDto.getBody();
        Vehicle vehicleEntity = new Vehicle();
        bookings.setVehicle(VehicleMapper.mapToEntity(vehicleDetails, vehicleEntity));

        // Set Booking code
        bookings.setBookingCode(generateBookingCode());

        bookings.setPickupBranch(bookingDto.getPickUpBranch());
        String dropOffBranch = bookingDto.getDropOffBranch();
        if (dropOffBranch == null || dropOffBranch.isEmpty()) {
            dropOffBranch = bookingDto.getPickUpBranch();
        }
        bookings.setDropOffBranch(dropOffBranch);
        BookingsMapper.mapToEntity(bookingDto, bookings);

        bookingsRepository.save(bookings);
        return true;
    }

    private String generateBookingCode() {
        final Optional<Bookings> last = bookingsRepository.findTopByOrderByBookingCodeDesc();
        if (!last.isPresent() || last.get().getBookingCode() == null) {
            return "B0001";
        }
        String lastCode = last.get().getBookingCode();
        int codeNumber = Integer.parseInt(lastCode.substring(1)) + 1;
        return "B" + String.format("%04d", codeNumber);
    }

    @Override
    public List<BookingsDto> fetchBookingHistory(String correlationId, String email) {

        // Fetch user details
        ResponseEntity<AppUsersDto> appUserDto =
                userServiceFeignClient.fetchAppUser(correlationId, email);
        if (appUserDto == null || appUserDto.getBody() == null) {
            return List.of();
        }
        Long asurId = appUserDto.getBody().getAusrId();
        Optional<List<Bookings>> optionalBookingsList = bookingsRepository.findByAusrId(asurId);
        if (optionalBookingsList.isEmpty()) {
            return List.of();
        }
        List<Bookings> bookingsList = optionalBookingsList.get();

        List<BookingsDto> bookinsDtoList = bookingsList.stream().map(BookingsMapper::convertToDto)
                .collect(Collectors.toList());
        return bookinsDtoList;
    }
}
