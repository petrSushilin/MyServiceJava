package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class GetAllTodayTicketsHandler {
    private final TicketService ticketService;

    public GetAllTodayTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
