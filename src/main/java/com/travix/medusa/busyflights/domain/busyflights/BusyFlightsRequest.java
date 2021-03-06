package com.travix.medusa.busyflights.domain.busyflights;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;

public class BusyFlightsRequest {
    private static final String DATE_PATTERN = DateTimeFormatter.ISO_LOCAL_DATE.toString();

    @NotNull
    private String origin;

    @NotNull
    private String destination;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String departureDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String returnDate;

    @Min(value = 1)
    private int numberOfPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
