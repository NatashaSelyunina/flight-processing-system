package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("FilterFlightService is work: ")
public class FilterFlightServiceTest {
//
//    @BeforeEach
//     void setUp() {
//        List<Flight> flights = FlightBuilder.createFlights();
//    }

    @Test
    void test1() {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filter = new FilterDepartureBeforeCurrentTime();
        List<Flight> filteredFlights = filter.filter(flights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void test2() {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filter = new FilterArrivalDateEarlierDepartureDate();
        List<Flight> filteredFlights = filter.filter(flights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void test3() {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filter = new FilterIntervalBetweenArrivalAndDepartureMoreTwoHours();
        List<Flight> filteredFlights = filter.filter(flights);
        Assertions.assertEquals(5, filteredFlights.size());
    }
}
