package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class FilterDepartureBeforeCurrentTime implements FilterService {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .toList();
    }
}
