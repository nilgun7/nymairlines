package com.nilgun.dto;

public record FlightResponse(
        Long id,
        String flightNumber,
        String departure,
        String arrival,
        Integer availableSeats,
        Double price
) {}
