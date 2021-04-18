package com.airiline.tickets.service;

import com.airiline.tickets.dto.purchase.PurchaseTicketRequest;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;

public interface PurchaseService {
    PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest);
}
