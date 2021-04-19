package com.airiline.tickets.controller;

import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.flight.*;
import com.airiline.tickets.service.FlightService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor
@RestController
@RequestMapping(FlightController.FLIGHT_URL)
public class FlightController {
    public static final String FLIGHT_URL = "/v1/ats/flights";
    public static final String SEARCH_URL = "/search";

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<CreateFlightResponse> save(@RequestBody CreateFlightRequest flight) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight));
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponse> getById(@PathVariable Long flightId) {
        return ResponseEntity.ok(flightService.getById(flightId));
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> delete(@PathVariable Long flightId) {
        flightService.deleteById(flightId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{flightId}")
    public ResponseEntity<FlightResponse> update(@PathVariable Long flightId,
                                                 @RequestBody UpdateFlightRequest flightRequest) {
        return ResponseEntity.ok(flightService.update(flightId, flightRequest));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page.", defaultValue = "20")
    })
    @PostMapping(SEARCH_URL)
    public ResponseEntity<PageResponse<FlightResponse>> search(@RequestBody SearchFlightRequest searchFlightRequest,
                                                               @ApiIgnore Pageable pageable) {
        return ResponseEntity.ok(flightService.searchByCriteria(searchFlightRequest, pageable));
    }
}
