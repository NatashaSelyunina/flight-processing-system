package com.gridnine.testing;

import java.util.List;

public class FilterFlightService {

    private final List<Filter> filters;

    public FilterFlightService(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = flights;
        for (Filter filter : filters) {
            filteredFlights = filter.filter(filteredFlights);
        }
        return filteredFlights;
    }
}
