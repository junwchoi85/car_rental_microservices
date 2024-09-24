from rest_framework.views import APIView
from rest_framework.response import Response
from core.use_cases.ping_use_case import PingUseCase


class PingController(APIView):
    def __init__(self):
        self.ping_use_case = PingUseCase()

    def get(self, request):
        response = self.ping_use_case.execute()
        return Response(response)
