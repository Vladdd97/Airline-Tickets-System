package com.airiline.tickets.service.impl;

import com.airiline.tickets.dto.purchase.PurchaseTicketRequest;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;
import com.airiline.tickets.mapper.PurchaseMapper;
import com.airiline.tickets.service.FlightService;
import com.airiline.tickets.service.PassengerService;
import com.airiline.tickets.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PassengerService passengerService;
    private final FlightService flightService;

    @Override
    public PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) {
        var flight = flightService.findById(purchaseTicketRequest.getFlightId());

        var passenger = passengerService.findByPassportNumber(purchaseTicketRequest.getPassenger()
                .getPassportNumber()).orElseGet(() -> passengerService.saveEntity(purchaseTicketRequest.getPassenger()));

        //TODO Create ticket

        //TODO Assign client to the ticket

        //TODO Decrement flight tickets count

        //TODO Return purchase token

        return PurchaseMapper.INSTANCE.flightToPurchaseTicketResponse(flight);
    }
}
