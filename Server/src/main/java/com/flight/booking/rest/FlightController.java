package com.flight.booking.rest;

import com.flight.booking.models.Flight;
import com.flight.booking.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FlightController {
    @Autowired
    FlightRepo flightRepo;

    @GetMapping("flights")
    List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @PostMapping("/flight/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        flightRepo.save(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}