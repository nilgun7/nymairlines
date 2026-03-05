package com.nilgun.dto;

public record BookingRequest(
        Long flightId,
        String passengerName,
        String passengerEmail
) {}