# Car Rental Microservice Backend

## Project Description
A Spring Boot-based microservice architecture for managing a car rental application backend. This system is designed to be scalable, secure, and efficient, supporting real-time booking, user management, and branch location services.

## Architecture

The backend is organized as a microservice architecture, with each core function developed as an independent service. Key services include:

- User Service: Handles user registration, authentication, and profile management.
- Vehicle Service: Manages vehicle listings, availability, and inventory.
- Booking Service: Manages reservations, schedules, and payment processing.
 -Branch Service: Provides location data and details for car rental branches.
 -Gateway Server: Acts as a single entry point, routing requests to appropriate services.



## Getting Started

Follow these instructions to set up and run the project locally.

### Prerequisitesx

- Java 11 or higher
- Docker: To run services in containers

### Installation
1. Clone the Repository
```
git clone https://github.com/junwchoi85/car_rental_microservices.git
```

2. Run Services with Docker Compose
```
docker-compose up -d
```

## Credit

We would like to acknowledge the following individuals for their contributions to this project:
- [Jun Hwan Choi] : Software Architect, Developer

## Contributing

Contributions are welcome! Please fork the repository and create a pull request to contribute.

## License

MIT License

Copyright (c) 2024 Jun Hwan Choi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.