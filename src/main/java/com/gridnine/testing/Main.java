package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        Filter filterDepartureBeforeCurrentTime = new FilterDepartureBeforeCurrentTime();
        Filter filterArrivalDateEarlierDepartureDate = new FilterArrivalDateEarlierDepartureDate();
        Filter filterIntervalBetweenArrivalAndDepartureMoreTwoHours =
                new FilterIntervalBetweenArrivalAndDepartureMoreTwoHours();

        System.out.println("Filter: Departure Before Current Time:");
        List<Flight> filteredByDepartureBeforeCurrentTime = filterDepartureBeforeCurrentTime.filter(flights);
        filteredByDepartureBeforeCurrentTime.forEach(System.out::println);
        System.out.println();

        System.out.println("Filter: Arrival Date Earlier Than Departure Date:");
        List<Flight> filteredByArrival = filterArrivalDateEarlierDepartureDate.filter(flights);
        filteredByArrival.forEach(System.out::println);
        System.out.println();

        System.out.println("Filter: Interval Between Arrival and Departure More Than Two Hours:");
        List<Flight> filteredByInterval = filterIntervalBetweenArrivalAndDepartureMoreTwoHours.filter(flights);
        filteredByInterval.forEach(System.out::println);
        System.out.println();

        List<Filter> filters = List.of(
                filterDepartureBeforeCurrentTime,
                filterArrivalDateEarlierDepartureDate,
                filterIntervalBetweenArrivalAndDepartureMoreTwoHours);

        FilterFlightService service = new FilterFlightService(filters);
        List<Flight> filteredFlights = service.filterFlights(flights);

        System.out.println("All Filters:");
        filteredFlights.forEach(System.out::println);
    }
}
