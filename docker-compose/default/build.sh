#!/bin/bash

# Define an array of service directories
services=("configserver" "eurekaserver" "booking-service" "car-listing-service" "payment-service" "user-service")

# Loop through each service directory and run jib:dockerBuild
for service in "${services[@]}"; do
  echo "Building Docker image for $service..."
  (cd "../../$service" && ./mvnw compile jib:dockerBuild)
  if [ $? -ne 0 ]; then
    echo "Failed to build Docker image for $service"
    exit 1
  fi
done

echo "All services have been successfully built."