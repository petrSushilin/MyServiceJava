package ru.medicaltickets.MyServiceJava.ticket.handlers;

import ru.medicaltickets.MyServiceJava.ticket.TicketService;

public class GetAllTicketsByClinicHandler {
    private TicketService ticketService;

    public GetAllTicketsByClinicHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
