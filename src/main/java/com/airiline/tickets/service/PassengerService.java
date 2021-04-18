package com.airiline.tickets.service;

import com.airiline.tickets.domain.Passenger;
import com.airiline.tickets.dto.purchase.PassengerInfo;

import java.util.Optional;

public interface PassengerService {
    Passenger saveEntity(PassengerInfo passengerInfo);

    Optional<Passenger> findByPassportNumber(String passportNumber);
}
