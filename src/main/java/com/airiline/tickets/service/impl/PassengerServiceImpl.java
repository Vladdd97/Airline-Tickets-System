package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Passenger;
import com.airiline.tickets.dto.purchase.PassengerInfo;
import com.airiline.tickets.mapper.PassengerMapper;
import com.airiline.tickets.repository.PassengerRepository;
import com.airiline.tickets.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Override
    public Passenger saveEntity(PassengerInfo passengerInfo) {
        return passengerRepository.save(PassengerMapper.INSTANCE.passengerInfoToPassenger(passengerInfo));
    }

    @Override
    public Optional<Passenger> findByPassportNumber(String passportNumber) {
        return passengerRepository.findByPassportNumber(passportNumber);
    }
}
