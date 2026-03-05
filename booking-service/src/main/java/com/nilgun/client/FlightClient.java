package com.nilgun.client;

import com.nilgun.dto.FlightResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "flight-service")
public interface FlightClient {

    @GetMapping("/api/v1/flights/{id}")
    FlightResponse getFlightById(@PathVariable("id") Long id);
}