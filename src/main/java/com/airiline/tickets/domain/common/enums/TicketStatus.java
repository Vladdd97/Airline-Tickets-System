package com.airiline.tickets.domain.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicketStatus {
    AVAILABLE("Available"),
    BOOKED("Booked"),
    PURCHASED("Purchased");

    @JsonValue
    private final String label;
}
