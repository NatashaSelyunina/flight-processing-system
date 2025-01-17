package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        System.out.println();

        List<Filter> filters = List.of(
                new FilterDepartureBeforeCurrentTime(),
                new FilterArrivalDateEarlierDepartureDate(),
                new FilterIntervalBetweenArrivalAndDepartureMoreTwoHours()
        );

        FilterFlightService service = new FilterFlightService(filters);
        List<Flight> filteredFlights = service.filterFlights(flights);

        filteredFlights.forEach(System.out::println);
    }
}
