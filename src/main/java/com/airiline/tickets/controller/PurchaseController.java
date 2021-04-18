package com.airiline.tickets.controller;

import com.airiline.tickets.dto.purchase.PurchaseTicketRequest;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;
import com.airiline.tickets.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(PurchaseController.PURCHASE_URL)
public class PurchaseController {
    public static final String PURCHASE_URL = "/v1/ats/purchases";

    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseTicketResponse> purchase(@Valid @RequestBody PurchaseTicketRequest purchaseTicketRequest){
        return ResponseEntity.ok(purchaseService.purchaseTicket(purchaseTicketRequest));
    }
}
