from abc import ABC, abstractmethod
from core.entities.bookings import Bookings


class BookingsRepository(ABC):

    @abstractmethod
    def create_booking(self, booking: Bookings) -> Bookings:
        pass

    @abstractmethod
    def get_booking(self, booking_id: int) -> Bookings:
        pass

    @abstractmethod
    def update_booking(self, booking: Bookings) -> Bookings:
        pass

    @abstractmethod
    def delete_booking(self, booking_id: int) -> None:
        pass
