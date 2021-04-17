package com.airiline.tickets.controller;

import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.airport.AirportResponse;
import com.airiline.tickets.dto.airport.CreateAirportRequest;
import com.airiline.tickets.dto.airport.CreateAirportResponse;
import com.airiline.tickets.dto.airport.UpdateAirportRequest;
import com.airiline.tickets.service.AirportService;
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
@RequestMapping(AirportController.AIRPORT_URL)
public class AirportController {
    public static final String AIRPORT_URL = "/v1/ats/airports";

    private final AirportService airportService;

    @PostMapping
    public ResponseEntity<CreateAirportResponse> save(@RequestBody CreateAirportRequest airportRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.save(airportRequest));
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportResponse> getById(@PathVariable Long airportId){
        return ResponseEntity.ok(airportService.getById(airportId));
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long airportId){
        airportService.deleteById(airportId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{airportId}")
    public ResponseEntity<AirportResponse> update(@PathVariable Long airportId,
                                                  @RequestBody UpdateAirportRequest airportRequest){
        return ResponseEntity.ok(airportService.update(airportId, airportRequest));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page.", defaultValue = "20")
    })
    @GetMapping
    public ResponseEntity<PageResponse<AirportResponse>> getAll(@ApiIgnore Pageable pageable){
        return ResponseEntity.ok(airportService.getAll(pageable));
    }
}
