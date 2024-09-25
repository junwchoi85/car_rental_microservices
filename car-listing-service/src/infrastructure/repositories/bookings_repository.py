from core.repositories.bookings_repository import BookingsRepository
from core.entities.bookings import Bookings
from rental.infrastructure.orm.bookings_model import BookingsModel


class DjangoBookingsRepository(BookingsRepository):
    def create_booking(self, booking: Bookings):
        booking_model = BookingsModel.objects.create(
            customer_id=booking.customer_id,
            car_detail_id=booking.car_detail_id,
            start_date=booking.start_date,
            end_date=booking.end_date,
            total_fee=booking.total_fee,
            status=booking.status,
            created_by=booking.created_by,
            updated_by=booking.updated_by
        )
        return booking_model

    def get_booking(self, booking_id: int) -> Bookings:
        booking_model = BookingsModel.objects.get(booking_id=booking_id)
        return self._to_entity(booking_model)

    def update_booking(self, booking: Bookings):
        booking_model = BookingsModel.objects.get(
            booking_id=booking.booking_id)
        booking_model.customer_id = booking.customer_id
        booking_model.car_detail_id = booking.car_detail_id
        booking_model.start_date = booking.start_date
        booking_model.end_date = booking.end_date
        booking_model.total_fee = booking.total_fee
        booking_model.status = booking.status
        booking_model.updated_by = booking.updated_by
        booking_model.save()

    def delete_booking(self, booking_id: int):
        BookingsModel.objects.filter(booking_id=booking_id).delete()

    def _to_entity(self, booking_model):
        return Bookings(
            booking_id=booking_model.booking_id,
            customer_id=booking_model.customer_id,
            car_detail_id=booking_model.car_detail_id,
            start_date=booking_model.start_date,
            end_date=booking_model.end_date,
            total_fee=booking_model.total_fee,
            status=booking_model.status,
            created_at=booking_model.created_at,
            created_by=booking_model.created_by,
            updated_at=booking_model.updated_at,
            updated_by=booking_model.updated_by
        )
