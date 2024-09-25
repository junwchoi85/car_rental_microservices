from core.repositories.bookings_repository import BookingsRepository
from core.entities.bookings import Bookings
from infrastructure.databases.bookings_django_model import BookingsModel


class DjangoBookingsRepository(BookingsRepository):

    def create_booking(self, booking: Bookings) -> Bookings:
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
        return self._convert_to_entity(booking_model)

    def get_booking(self, booking_id: int) -> Bookings:
        booking_model = BookingsModel.objects.get(pk=booking_id)
        return self._convert_to_entity(booking_model)

    def update_booking(self, booking: Bookings) -> Bookings:
        booking_model = BookingsModel.objects.get(pk=booking.booking_id)
        booking_model.customer_id = booking.customer_id
        booking_model.car_detail_id = booking.car_detail_id
        booking_model.start_date = booking.start_date
        booking_model.end_date = booking.end_date
        booking_model.total_fee = booking.total_fee
        booking_model.status = booking.status
        booking_model.updated_by = booking.updated_by
        booking_model.save()
        return self._convert_to_entity(booking_model)

    def delete_booking(self, booking_id: int) -> None:
        BookingsModel.objects.filter(pk=booking_id).delete()

    def _convert_to_entity(self, booking_model: BookingsModel) -> Bookings:
        return Bookings(
            booking_id=booking_model.id,
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
