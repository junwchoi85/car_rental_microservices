package io.classiccrew.booking_service.service.impl;


import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.classiccrew.booking_service.dto.AppUsersDto;
import io.classiccrew.booking_service.dto.BookingsDto;
import io.classiccrew.booking_service.dto.VehicleDto;
import io.classiccrew.booking_service.entity.Bookings;
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
    public boolean bookCar(BookingsDto bookingDto) {
        Bookings bookings = new Bookings();

        // Fetch user details
        String userEmail = bookingDto.getUserEmail();
        ResponseEntity<AppUsersDto> appUserDto = userServiceFeignClient.fetchAppUser(userEmail);
        if (appUserDto == null || appUserDto.getBody() == null) {
            return false;
        }
        Long asurId = appUserDto.getBody().getAusrId();
        bookings.setAusrId(asurId);

        // Fetch Vehicle details
        String vehicleCode = bookingDto.getCarCode();
        ResponseEntity<VehicleDto> vehicleDto = carServiceFeignClient.fetchCarInfo(vehicleCode);
        if (vehicleDto == null || vehicleDto.getBody() == null) {
            return false;
        }
        Long vehicleId = vehicleDto.getBody().getVehicleId();
        bookings.setVehicleId(vehicleId);

        // Set Booking code
        bookings.setBookingCode(generateBookingCode());


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


}
