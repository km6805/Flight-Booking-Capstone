package com.flight.booking.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRow {
    private String sku;
    private String airline;
    private String departure;
    private String arrival;
    private String date;
    private String time;
    private int price;


}
