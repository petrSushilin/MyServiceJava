package ru.medicaltickets.MyServiceJava.ticket.handlers;

import ru.medicaltickets.MyServiceJava.ticket.TicketService;

public class GetAllMonthTicketsHandler {
    private TicketService ticketService;

    public GetAllMonthTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
