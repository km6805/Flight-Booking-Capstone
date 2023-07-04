package com.flight.booking.repo;

import com.flight.booking.models.FlightsBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsBookRepo extends JpaRepository<FlightsBook,String> {
}
