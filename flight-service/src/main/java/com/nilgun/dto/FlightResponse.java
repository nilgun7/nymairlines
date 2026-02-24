package com.nilgun.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FlightResponse(String flightNumber, String departure, String arrival,
                              LocalDateTime departureTime, LocalDateTime arrivalTime,
                              Double price) {
}
