package com.nilgun.repository;

import com.nilgun.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightServiceRepository extends JpaRepository<Flight, Long> {
}
