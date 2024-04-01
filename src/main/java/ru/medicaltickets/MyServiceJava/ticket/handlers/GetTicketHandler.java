package ru.medicaltickets.MyServiceJava.ticket.handlers;

import ru.medicaltickets.MyServiceJava.ticket.TicketService;

public class GetTicketHandler {
    private TicketService ticketService;

    public GetTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
