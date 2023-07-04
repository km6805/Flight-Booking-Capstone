package com.flight.booking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FlightCartItem {
    @Id
    private Integer id;
    @ManyToOne
    private Flight flight;
}
