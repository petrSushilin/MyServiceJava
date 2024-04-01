package ru.medicaltickets.MyServiceJava.ticket.handlers;

import ru.medicaltickets.MyServiceJava.ticket.TicketService;

public class GetAllTodayTicketsHandler {
    private TicketService ticketService;

    public GetAllTodayTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
