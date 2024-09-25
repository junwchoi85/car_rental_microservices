from django.urls import path
from interfaces.controllers.ping_controller import PingController
from interfaces.controllers.bookings_controller import BookingsController

urlpatterns = [
    path('ping/', PingController.as_view(), name='ping'),
    path('bookings/', BookingsController.as_view(),
         name='bookings-create'),  # POST
    path('bookings/<int:booking_id>/', BookingsController.as_view(),
         name='bookings-detail'),  # GET, PUT, DELETE
]
