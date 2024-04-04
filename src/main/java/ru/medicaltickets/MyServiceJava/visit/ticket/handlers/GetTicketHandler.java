package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.util.List;

public class GetTicketHandler {
    private final TicketService ticketService;

    public GetTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<?> handle(String ticketID) {
        return ticketService.getSingle(Long.valueOf(ticketID));
    }

    public ResponseEntity<List<?>> handle() {
        return ticketService.getAll();
    }
}
