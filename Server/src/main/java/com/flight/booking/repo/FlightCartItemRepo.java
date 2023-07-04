package com.flight.booking.repo;

import com.flight.booking.models.FlightCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightCartItemRepo extends JpaRepository<FlightCartItem, Integer> {
}
