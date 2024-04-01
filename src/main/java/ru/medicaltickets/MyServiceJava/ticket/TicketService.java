package ru.medicaltickets.MyServiceJava.ticket;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }
}
