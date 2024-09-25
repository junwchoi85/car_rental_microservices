# core/use_cases/bookings_use_case.py

from core.entities.bookings import Bookings
from core.repositories.bookings_repository import BookingsRepository


class BookingsUseCase:
    def __init__(self, repository: BookingsRepository):
        self.repository = repository

    def create_booking(self, booking: Bookings):
        return self.repository.create_booking(booking)

    def get_booking(self, booking_id: int) -> Bookings:
        return self.repository.get_booking(booking_id)

    def update_booking(self, booking: Bookings):
        return self.repository.update_booking(booking)

    def delete_booking(self, booking_id: int):
        return self.repository.delete_booking(booking_id)
