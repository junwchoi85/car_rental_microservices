from django.db import models


class BookingsModel(models.Model):
    booking_id = models.AutoField(primary_key=True)
    customer_id = models.IntegerField()
    car_detail_id = models.IntegerField()
    start_date = models.DateTimeField()
    end_date = models.DateTimeField()
    total_fee = models.FloatField()
    status = models.CharField(max_length=50)
    created_at = models.DateTimeField(auto_now_add=True)
    created_by = models.CharField(max_length=100)
    updated_at = models.DateTimeField(auto_now=True)
    updated_by = models.CharField(max_length=100)

    class Meta:
        db_table = 'bookings'
