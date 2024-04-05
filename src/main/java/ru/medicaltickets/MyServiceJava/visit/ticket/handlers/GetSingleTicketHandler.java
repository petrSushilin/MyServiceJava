package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class GetSingleTicketHandler {
    private final TicketService ticketService;

    public GetSingleTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<?> handle(String ticketID) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getSingle(Long.valueOf(ticketID)));
    }
}
