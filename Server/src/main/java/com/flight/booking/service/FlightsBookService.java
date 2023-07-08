package com.flight.booking.service;

import com.flight.booking.models.Flight;
import com.flight.booking.models.FlightCartItem;
import com.flight.booking.models.FlightsBook;
import com.flight.booking.repo.FlightCartItemRepo;
import com.flight.booking.repo.FlightRepo;
import com.flight.booking.repo.FlightsBookRepo;
import com.flight.booking.rest.BookRow;
import com.flight.booking.rest.FlightsBookItemRequest;
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
    @Autowired
    FlightCartItemRepo flightCartItemRepo;
    @Autowired
    FlightRepo flightRepo;

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

    public FlightsBookResponse addFlightToBook(String id, FlightsBookItemRequest flightCartItemRequest) {
        FlightsBook flightsBook = getFlightsBookFromDatabase(id);
        Optional<FlightCartItem> optionalFlightCartItem = getExistingFlight(flightsBook,flightCartItemRequest);
        if(optionalFlightCartItem.isPresent()){
            return generateFlightBook(flightsBook);
        }
        Flight flight = flightRepo.findFlightBySku(flightCartItemRequest.getSku());
        FlightCartItem flightCartItem = new FlightCartItem(null,flight);
        flightCartItem = flightCartItemRepo.save(flightCartItem);
        flightsBook.getFlightCartItems().add(flightCartItem);
        flightsBookRepo.save(flightsBook);
        return generateFlightBook(flightsBook);
    }
    private FlightsBookResponse generateFlightBook(FlightsBook flightsBook) {
        List<FlightCartItem> flights = flightsBook.getFlightCartItems();
        List<BookRow> bookRowList = new ArrayList<>();
        for(int i = 0;i<flights.size();i++) {
            FlightCartItem flightCartItem = flights.get(i);
            String sku = flightCartItem.getFlight().getSku();
            String airline = flightCartItem.getFlight().getAirline();
            String departure = flightCartItem.getFlight().getDeparture();
            String arrival = flightCartItem.getFlight().getArrival();
            String date = flightCartItem.getFlight().getDate();
            String time = flightCartItem.getFlight().getTime();
            int price = flightCartItem.getFlight().getPrice();
            BookRow bookRow = new BookRow(sku,airline,departure,arrival,date,time,price);
            bookRowList.add(bookRow);
        }
        return new FlightsBookResponse(bookRowList);
    }


    private Optional<FlightCartItem> getExistingFlight(FlightsBook flightsBook, FlightsBookItemRequest flightCartItems) {
        for(FlightCartItem flightCartItem: flightsBook.getFlightCartItems()) {
            if (flightCartItem.getFlight().getSku().equals(flightCartItems.getSku())) {
                return Optional.of(flightCartItem);
            }
        } return Optional.empty();
    }
    }

