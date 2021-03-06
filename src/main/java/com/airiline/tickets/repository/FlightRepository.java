package com.airiline.tickets.repository;

import com.airiline.tickets.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, SearchFlightRepository {
}
