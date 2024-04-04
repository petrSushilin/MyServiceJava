package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.visit.ticket.Ticket;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.util.List;

public class GetAllTicketsByClinicHandler {
    private final TicketService ticketService;

    public GetAllTicketsByClinicHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID) {
        return ticketService.getByClinic(Long.valueOf(clinicID));
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfVisit) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfVisit = LocalDate.parse(dateOfVisit);
        return ticketService.getByClinic(parsedClinicID, parsedDateOfVisit);
    }
}
