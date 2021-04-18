package com.airiline.tickets.repository;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.flight.SearchFlightRequest;

public interface SearchFlightRepository {
    PageResponse<Flight> searchByCriteria(SearchFlightRequest searchFlightRequest, int page, int size);
}
