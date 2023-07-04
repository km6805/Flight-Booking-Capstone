package com.flight.booking.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightsBookResponse {
    List<BookRow> bookRows = new ArrayList<>();
}
