package com.flight.booking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class FlightsBook {
    @Id
    private String id;
    @OneToMany
    private List<FlightCartItem> flightCartItems;

}
