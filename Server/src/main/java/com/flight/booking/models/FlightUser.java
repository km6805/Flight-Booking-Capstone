package com.flight.booking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class FlightUser {
    @Id
    private Integer id;
    @Column(unique = true)
    private String username;
    @OneToOne
    private FlightsBook flightsBook;

}
