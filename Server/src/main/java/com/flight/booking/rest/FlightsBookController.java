package com.flight.booking.rest;

import com.flight.booking.service.FlightsBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightsBookController {
    @Autowired
    FlightsBookService flightsBookService;

    @GetMapping("flight/book/{id}")
    public ResponseEntity<FlightsBookResponse> getFlightBookById(@PathVariable String id) {
        FlightsBookResponse flightsBookResponse = flightsBookService.getBookById(id);
        return new ResponseEntity<>(flightsBookResponse, HttpStatus.OK);
    }
}
