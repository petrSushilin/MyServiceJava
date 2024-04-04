package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.global.exceptions.IdentifierMismatchException;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class UpdateTicketHandler {
    private final TicketService ticketService;

    public UpdateTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<?> handle(String ticketID, Ticket ticket) {
        Long parsedTicketID = Long.valueOf(ticketID);
        if (ticket.getID() != parsedTicketID) throw new IdentifierMismatchException("Attempt to throw a forbidden ID");
        return ticketService.post(ticket);
    }
}
