package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        List<Filter> filters = List.of(
                new FilterDepartureBeforeCurrentTime(),
                new FilterArrivalDateEarlierDepartureDate(),
                new FilterIntervalBetweenArrivalAndDepartureMoreTwoHours()
        );

        FilterFlightService service = new FilterFlightService(filters);
        List<Flight> filteredFlights = service.filterFlights(flights);

        for (Flight flight : filteredFlights) {
            System.out.println(flight);
            System.out.println();
        }
    }
}
