from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from core.use_cases.bookings_use_case import BookingsUseCase
from core.entities.bookings import Bookings
from django.http import JsonResponse


class BookingsController(APIView):

    def __init__(self, use_case: BookingsUseCase):
        self.use_case = use_case

    def post(self, request):
        """Create a new booking."""
        booking = Bookings(
            booking_id=None,  # 새 레코드이므로 ID는 None
            customer_id=request.data['customer_id'],
            car_detail_id=request.data['car_detail_id'],
            start_date=request.data['start_date'],
            end_date=request.data['end_date'],
            total_fee=request.data['total_fee'],
            status=request.data['status'],
            created_at=None,
            created_by=request.data['created_by'],
            updated_at=None,
            updated_by=request.data['updated_by']
        )
        created_booking = self.use_case.create_booking(booking)
        return JsonResponse({
            "message": "Booking created",
            "booking_id": created_booking.booking_id
        }, status=status.HTTP_201_CREATED)

    def get(self, request, booking_id=None):
        """Retrieve a specific booking by its ID."""
        if booking_id is not None:
            try:
                booking = self.use_case.get_booking(booking_id)
                return JsonResponse({
                    "booking_id": booking.booking_id,
                    "customer_id": booking.customer_id,
                    "car_detail_id": booking.car_detail_id,
                    "start_date": booking.start_date,
                    "end_date": booking.end_date,
                    "total_fee": booking.total_fee,
                    "status": booking.status,
                    "created_by": booking.created_by,
                    "updated_by": booking.updated_by
                }, status=status.HTTP_200_OK)
            except Exception:
                return JsonResponse({"error": "Booking not found"}, status=status.HTTP_404_NOT_FOUND)

        return JsonResponse({"error": "Booking ID not provided"}, status=status.HTTP_400_BAD_REQUEST)

    def put(self, request, booking_id):
        """Update an existing booking."""
        try:
            booking = self.use_case.get_booking(booking_id)
            booking.customer_id = request.data['customer_id']
            booking.car_detail_id = request.data['car_detail_id']
            booking.start_date = request.data['start_date']
            booking.end_date = request.data['end_date']
            booking.total_fee = request.data['total_fee']
            booking.status = request.data['status']
            booking.updated_by = request.data['updated_by']

            updated_booking = self.use_case.update_booking(booking)
            return JsonResponse({
                "message": "Booking updated",
                "booking_id": updated_booking.booking_id
            }, status=status.HTTP_200_OK)
        except Exception:
            return JsonResponse({"error": "Booking not found"}, status=status.HTTP_404_NOT_FOUND)

    def delete(self, request, booking_id):
        """Delete a specific booking by its ID."""
        try:
            self.use_case.delete_booking(booking_id)
            return JsonResponse({"message": "Booking deleted"}, status=status.HTTP_204_NO_CONTENT)
        except Exception:
            return JsonResponse({"error": "Booking not found"}, status=status.HTTP_404_NOT_FOUND)
