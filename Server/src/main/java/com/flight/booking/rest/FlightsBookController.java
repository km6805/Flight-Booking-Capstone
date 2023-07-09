package com.flight.booking.rest;

import com.flight.booking.service.FlightsBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FlightsBookController {
    @Autowired
    FlightsBookService flightsBookService;

    @GetMapping("/flight/book/{id}")
    public ResponseEntity<FlightsBookResponse> getFlightBookById(@PathVariable String id) {
        FlightsBookResponse flightsBookResponse = flightsBookService.getBookById(id);
        return new ResponseEntity<>(flightsBookResponse, HttpStatus.OK);
    }

    @PostMapping("/flight-book/{id}")
    public ResponseEntity<FlightsBookResponse> addToBook(@PathVariable String id,@RequestBody FlightsBookItemRequest flightsBookItemRequest) {
        FlightsBookResponse flightsBookResponse = flightsBookService.addFlightToBook(id,flightsBookItemRequest);
        return new ResponseEntity<>(flightsBookResponse,HttpStatus.OK);
    }

    @DeleteMapping("/flight-book/{bookId}/{sku}")
    public ResponseEntity<FlightsBookResponse> deleteFromBook(@PathVariable String bookId, @PathVariable String sku) {
        FlightsBookResponse flightsBookResponse = flightsBookService.deleteFlightFromBook(bookId,sku);
        return new ResponseEntity<>(flightsBookResponse,HttpStatus.OK);
    }
}
