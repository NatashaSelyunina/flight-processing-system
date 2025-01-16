package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class FilterIntervalBetweenArrivalAndDepartureMoreTwoHours implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 1; i < segments.size(); i++) {
                        LocalDateTime arrivalTime = segments.get(i - 1).getArrivalDate();
                        LocalDateTime departureTime = segments.get(i).getDepartureDate();
                        if (arrivalTime.plusHours(2).isBefore(departureTime)) {
                            return false;
                        }
                    }
                    return true;
                })
                .toList();
    }
}
