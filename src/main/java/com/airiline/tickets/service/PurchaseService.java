package com.airiline.tickets.service;

import com.airiline.tickets.dto.purchase.PurchaseTicketRequest;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PurchaseService {
    PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) throws JsonProcessingException;
}
