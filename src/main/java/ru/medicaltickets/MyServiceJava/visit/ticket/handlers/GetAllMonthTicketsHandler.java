package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class GetAllMonthTicketsHandler {
    private final TicketService ticketService;

    public GetAllMonthTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
