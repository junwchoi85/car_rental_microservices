from django.urls import path
from interfaces.controllers.ping_controller import PingController

urlpatterns = [
    path('ping/', PingController.as_view(), name='ping'),
]
