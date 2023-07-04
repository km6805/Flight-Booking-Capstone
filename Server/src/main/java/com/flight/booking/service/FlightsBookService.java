package com.flight.booking.service;

import com.flight.booking.models.Flight;
import com.flight.booking.models.FlightCartItem;
import com.flight.booking.models.FlightsBook;
import com.flight.booking.repo.FlightsBookRepo;
import com.flight.booking.rest.BookRow;
import com.flight.booking.rest.FlightsBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightsBookService {

    @Autowired
    FlightsBookRepo flightsBookRepo;

    public FlightsBookResponse getBookById(String id) {
        FlightsBook flightsBook = getFlightsBookFromDatabase(id);
        List<FlightCartItem> items = flightsBook.getFlightCartItems();
        List<BookRow> bookRowList = new ArrayList<>();
        for(int i = 0; i < items.size();i++){
            Flight flight = items.get(i).getFlight();
            String sku = flight.getSku();
            String airline = flight.getAirline();
            String departure = flight.getDeparture();
            String arrival = flight.getArrival();
            String date = flight.getDate();
            String time = flight.getTime();
            int price = flight.getPrice();
            BookRow bookRow = new BookRow(sku,airline,departure,arrival,date,time,price);
            bookRowList.add(bookRow);
        }
        return new FlightsBookResponse(bookRowList);
    }

    private FlightsBook getFlightsBookFromDatabase(String id) {
        Optional<FlightsBook> optional = flightsBookRepo.findById(id);
        return optional.get();
    }
}
