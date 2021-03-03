package com.airiline.tickets.domain.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TravelClass {
    FIRST("First"),
    BUSINESS("Business"),
    ECONOMY("Economy");

    @JsonValue
    private String label;
}
