package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class PostTicketHandler {
    private final TicketService ticketService;

    public PostTicketHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
