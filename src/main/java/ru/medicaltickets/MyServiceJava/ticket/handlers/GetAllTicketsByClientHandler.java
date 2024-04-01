package ru.medicaltickets.MyServiceJava.ticket.handlers;

import ru.medicaltickets.MyServiceJava.ticket.TicketService;

public class GetAllTicketsByClientHandler {
    private TicketService ticketService;

    public GetAllTicketsByClientHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
