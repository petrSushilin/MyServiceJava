package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class GetAllTicketsByClientHandler {
    private final TicketService ticketService;

    public GetAllTicketsByClientHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
