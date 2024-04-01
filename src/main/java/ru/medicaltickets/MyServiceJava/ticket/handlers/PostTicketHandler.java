package ru.medicaltickets.MyServiceJava.ticket.handlers;

import ru.medicaltickets.MyServiceJava.ticket.TicketService;

public class PostTicketHandler {
    private TicketService ticketService;

    public PostTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
