package com.nilgun.service;

import com.nilgun.dto.FlightRequest;
import com.nilgun.dto.FlightResponse;
import com.nilgun.entity.Flight;
import com.nilgun.repository.FlightServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightServiceRepository flightRepository;

    public List<FlightResponse> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private FlightResponse convertToResponse(Flight flight) {
        return FlightResponse.builder()
                .flightNumber(flight.getFlightNumber())
                .departure(flight.getDeparture())
                .arrival(flight.getArrival())
                .departureTime(flight.getDepartureTime())
                .price(flight.getPrice())
                .build();
    }

    public void createFlight(FlightRequest flightRequest) {
        Flight flight = Flight.builder()
                .flightNumber(flightRequest.flightNumber())
                .departure(flightRequest.departure())
                .arrival(flightRequest.arrival())
                .departureTime(flightRequest.departureTime())
                .price(flightRequest.price())
                .build();

        flightRepository.save(flight);
    }
}