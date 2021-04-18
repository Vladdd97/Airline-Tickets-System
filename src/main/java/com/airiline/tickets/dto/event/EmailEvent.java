package com.airiline.tickets.dto.event;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailEvent {
    private String to;
    private String subject;
    private String message;
}
