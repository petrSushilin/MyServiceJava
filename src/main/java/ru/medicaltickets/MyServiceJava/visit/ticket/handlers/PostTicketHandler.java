package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class PostTicketHandler {
    private final TicketService ticketService;

    public PostTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<?> handle(Ticket ticket) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.post(ticket));
    }
}
