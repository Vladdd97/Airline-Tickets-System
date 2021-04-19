package com.airiline.tickets.dto.purchase;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PurchaseTicketRequest {
    private long flightId;

    @NotNull
    @Valid
    private PassengerInfo passenger;

    @NotNull
    @Valid
    private CreditCard creditCard;
}
