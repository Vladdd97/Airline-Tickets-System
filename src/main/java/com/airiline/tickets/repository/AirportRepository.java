package com.airiline.tickets.repository;

import com.airiline.tickets.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
