package com.airiline.tickets.domain.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Title {
    MISTER("Mister"),
    MISS("Miss");

    @JsonValue
    private final String label;
}
