package com.flight.booking.repo;

import com.flight.booking.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, String> {
}
