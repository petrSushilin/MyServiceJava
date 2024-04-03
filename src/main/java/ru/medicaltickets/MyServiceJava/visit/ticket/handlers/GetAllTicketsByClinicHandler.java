package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

public class GetAllTicketsByClinicHandler {
    private final TicketService ticketService;

    public GetAllTicketsByClinicHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
