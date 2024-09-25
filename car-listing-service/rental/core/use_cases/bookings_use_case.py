from rental.core.entities.bookings import Bookings


class BookingsUseCase:

    def __init__(self, repository):
        self.repository = repository

    def create_booking(self, booking: Bookings) -> Bookings:
        return self.repository.create_booking(booking)

    def get_booking(self, booking_id: int) -> Bookings:
        return self.repository.get_booking(booking_id)

    def update_booking(self, booking: Bookings) -> Bookings:
        return self.repository.update_booking(booking)

    def delete_booking(self, booking_id: int) -> None:
        self.repository.delete_booking(booking_id)
