package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class GetTicketHandler {
    private final TicketService ticketService;

    public GetTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
