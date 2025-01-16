package com.gridnine.testing;

import java.util.List;

public class FilterArrivalDateEarlierDepartureDate implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .toList();
    }
}
