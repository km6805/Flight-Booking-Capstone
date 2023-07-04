package com.flight.booking.repo;

import com.flight.booking.models.FlightUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightUserRepo extends JpaRepository<FlightUser, Integer> {
}
