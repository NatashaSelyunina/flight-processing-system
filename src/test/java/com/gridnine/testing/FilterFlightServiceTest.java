package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("FilterFlightService is work: ")
public class FilterFlightServiceTest {

    private List<Flight> flights;

    @BeforeEach
     void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    void testFilterDepartureBeforeCurrentTime() {
        Filter filter = new FilterDepartureBeforeCurrentTime();
        List<Flight> filteredFlights = filter.filter(flights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void testFilterArrivalDateEarlierDepartureDate() {
        Filter filter = new FilterArrivalDateEarlierDepartureDate();
        List<Flight> filteredFlights = filter.filter(flights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void testFilterIntervalBetweenArrivalAndDepartureMoreTwoHours() {
        Filter filter = new FilterIntervalBetweenArrivalAndDepartureMoreTwoHours();
        List<Flight> filteredFlights = filter.filter(flights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void testThreeFilters() {
        Filter filterDepartureBeforeCurrentTime = new FilterDepartureBeforeCurrentTime();
        Filter filterArrivalDateEarlierDepartureDate = new FilterArrivalDateEarlierDepartureDate();
        Filter filterIntervalBetweenArrivalAndDepartureMoreTwoHours =
                new FilterIntervalBetweenArrivalAndDepartureMoreTwoHours();

        List<Filter> filters = List.of(
                filterDepartureBeforeCurrentTime,
                filterArrivalDateEarlierDepartureDate,
                filterIntervalBetweenArrivalAndDepartureMoreTwoHours
        );

        FilterFlightService service = new FilterFlightService(filters);
        List<Flight> filteredFlights = service.filterFlights(flights);
        Assertions.assertEquals(3, filteredFlights.size());
    }
}
