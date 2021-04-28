package com.airiline.tickets.exception;

public class NotEnoughAvailableTicketsException extends RuntimeException {
    public NotEnoughAvailableTicketsException(String message) {
        super(message);
    }
}
