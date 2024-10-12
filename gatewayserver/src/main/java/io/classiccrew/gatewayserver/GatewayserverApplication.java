package io.classiccrew.gatewayserver;

import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator routeConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(p -> p.path("/classiccrew/payment-service/**")
                .filters(f -> f
                        .rewritePath("/classiccrew/payment-service/(?<segment>.*)", "/${segment}")
                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                .uri("lb://PAYMENT-SERVICE"))
                .route(p -> p.path("/classiccrew/booking-service/**")
                        .filters(f -> f.rewritePath("/classiccrew/booking-service/(?<segment>.*)",
                                "/${segment}").addResponseHeader("X-Response-Time",
                                        LocalDateTime.now().toString()))
                        .uri("lb://BOOKING-SERVICE"))
                .route(p -> p.path("/classiccrew/car-listing-service/**").filters(
                        f -> f.rewritePath("/classiccrew/car-listing-service/(?<segment>.*)",
                                "/${segment}").addResponseHeader("X-Response-Time",
                                        LocalDateTime.now().toString()))
                        .uri("lb://CAR-LISTING-SERVICE"))
                .route(p -> p.path("/classiccrew/user-service/**")
                        .filters(f -> f.rewritePath("/classiccrew/user-service/(?<segment>.*)",
                                "/${segment}").addResponseHeader("X-Response-Time",
                                        LocalDateTime.now().toString()))
                        .uri("lb://USER-SERVICE"))
                .build();
    }
}
